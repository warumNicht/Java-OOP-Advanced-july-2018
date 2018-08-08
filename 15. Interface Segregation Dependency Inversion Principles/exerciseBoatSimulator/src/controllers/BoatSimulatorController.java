package controllers;

import Utility.Constants;
import contracts.IBoatSimulatorController;
import contracts.IModelable;
import contracts.IRace;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.Race;
import models.boats.*;
import models.engines.Engine;
import models.engines.Jet;
import models.engines.Sterndrive;


import java.util.*;


public class BoatSimulatorController implements IBoatSimulatorController {
    private static final String[] POSITIONS={"First","Second","Third"};

    private LinkedHashMap<Double, Boat> map;
    private List<Double> winnersTime;
    private List<Boat> finalWinners;
    private BoatSimulatorDatabase database;
    private IRace currentRace;


    public BoatSimulatorController(BoatSimulatorDatabase database, IRace currentRace) {
        this.setDatabase(database);
        this.setCurrentRace(currentRace);
    }

    public BoatSimulatorController() {
        this.setDatabase(new BoatSimulatorDatabase());
        this.setCurrentRace(null);
        this.map=new LinkedHashMap<>();
        this.winnersTime=new ArrayList<>();
        this.finalWinners=new ArrayList<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public String CreateBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        IModelable curEngine=null;
        if("Jet".equals(engineType)){
            curEngine=new Jet(model,horsepower,displacement);
        }else {
            curEngine=new Sterndrive(model,horsepower,displacement);
        }
        this.database.getEngines().Add(curEngine);
        return String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.",
                model,horsepower,displacement);
    }


    public void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public IRace getCurrentRace() {
        return this.currentRace;
    }

    public void setCurrentRace(IRace currentRace) {
        this.currentRace = currentRace;
    }

    public String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        IModelable engine=null;
        switch (engineType) {
            case Jet:
                engine = new Jet(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new Sterndrive(model, horsepower, displacement);
                break;
            default:

        }

        this.database.getEngines().Add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String CreateRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().Add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String CreateSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().Add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String CreatePowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        Engine firstEngine = (Engine) this.database.getEngines().GetItem(firstEngineModel);
        Engine secondEngine = (Engine) this.database.getEngines().GetItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight,firstEngine,secondEngine);
        this.database.getBoats().Add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String CreateYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        Engine engine = (Engine) this.database.getEngines().GetItem(engineModel);
        Boat boat = new Yacht(model, weight, cargoWeight, engine);
        this.database.getBoats().Add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.ValidateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().GetItem(model);
        this.ValidateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat instanceof PowerBoat) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.currentRace.AddParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();

        List<Boat> participants = this.currentRace.GetParticipants();

        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<Boat> timeComparator = (boat1, boat2) -> {
            double time1 =  boat1.calculateRaceSpeed(this.currentRace);
            double time2 =  boat2.calculateRaceSpeed(this.currentRace);
            if (time1 < 0 && time2 < 0) {
                return 0;
            }

            return Double.compare(time2, time1);
        };

        participants.sort(timeComparator);

        int index = 0;
        StringBuilder res=new StringBuilder();
        IRace race=this.currentRace;
        for(int i=0; i<3; i++){
            Boat participant=participants.get(i);
            res.append(String.format("%s place: %s Model: %s Time: %s",
                    POSITIONS[index++], participant.getClass().getSimpleName(),participant.getModel(),
                    participant.calculateRaceSpeed(race)<=0.0 ? "Did not finish!" :
                            String.format("%.2f sec",race.getDistance() / participant.calculateRaceSpeed(race))
            ))
                    .append(System.lineSeparator());
        }


        this.currentRace=null;

        return res.toString().trim();
    }

    private String isFinished(Double key) {
        if (key <=0) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String GetStatistic() {
        StringBuilder res=new StringBuilder();
        if(this.currentRace!=null){

            List<Boat> participants=this.currentRace.GetParticipants();

            int powerCount=0;
            int rowCount=0;
            int sailCount=0;
            int yachtCount=0;

            int participantsCount=participants.size();

            for (Boat participant : participants) {
                if(participant.getClass().getSimpleName().equals("PowerBoat")){
                    powerCount++;
                }else if(participant.getClass().getSimpleName().equals("RowBoat")){
                    rowCount++;
                }else if(participant.getClass().getSimpleName().equals("SailBoat")){
                    sailCount++;
                }else {
                    yachtCount++;
                }
            }

//            if(powerCount>0){
//                res.append(String.format("PowerBoat -> %.2f", (powerCount*100.0)/(participantsCount*1.0))  )
//                        .append("%")
//                        .append(System.lineSeparator());
//            }
//            if(rowCount>0){
//                res.append(String.format("RowBoat -> %.2f", (rowCount*100.0)/(participantsCount*1.0))  )
//                        .append("%")
//                        .append(System.lineSeparator());
//            }
//            if(sailCount>0){
//                res.append(String.format("SailBoat -> %.2f", (sailCount*100.0)/(participantsCount*1.0))  )
//                        .append("%")
//                        .append(System.lineSeparator());
//            }
//            if(yachtCount>0){
//                res.append(String.format("Yacht -> %.2f", (yachtCount*100.0)/(participantsCount*1.0))  )
//                        .append("%");
//            }

            if(participantsCount==0){
                res.append("PowerBoat -> 0.00%"   )
                        .append(System.lineSeparator())
                        .append("RowBoat -> 0.00%"  )
                        .append(System.lineSeparator())
                        .append("SailBoat -> 0.00%"  )
                        .append(System.lineSeparator())
                        .append("Yacht -> 0.00%");
            }else {
                res.append(String.format("PowerBoat -> %.2f", (powerCount*100.0)/(participantsCount*1.0))  )
                        .append("%")
                        .append(System.lineSeparator())
                        .append(String.format("RowBoat -> %.2f", (rowCount*100.0)/(participantsCount*1.0))  )
                        .append("%")
                        .append(System.lineSeparator())
                        .append(String.format("SailBoat -> %.2f", (sailCount*100.0)/(participantsCount*1.0))  )
                        .append("%")
                        .append(System.lineSeparator())
                        .append(String.format("Yacht -> %.2f", (yachtCount*100.0)/(participantsCount*1.0))  )
                        .append("%");
            }






        }
        //TODO Bonus Task Implement me
        return res.toString().trim();
    }
    private double calculateTime(Boat participant){
        Double speed = participant.calculateRaceSpeed(this.currentRace);
        Double time = this.currentRace.getDistance() / speed;
        return time;
    }

    private void FindFastest(List<Boat> participants) {
        Double bestTime = Double.MAX_VALUE; //ed
        Boat winner = null;
        for (Boat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if (time < bestTime) {
                bestTime = time;
                winner = participant;
            }
        }

        this.winnersTime.add(bestTime);
        this.finalWinners.add(winner);
        //map.put(bestTime, winner);
        participants.remove(winner);
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
