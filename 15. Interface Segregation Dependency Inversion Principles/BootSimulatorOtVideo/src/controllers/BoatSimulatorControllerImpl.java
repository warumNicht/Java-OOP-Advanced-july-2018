package controllers;

import Utility.Constants;
import contracts.*;
import exeptions.*;
import factories.BoatEngineFactory;
import factories.BoatFactory;
import factories.RaceFactory;

import java.util.Comparator;
import java.util.List;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    public static final String[] POSITIONS={"First","Second","Third"};

    private Database database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case "Jet":
                engine = BoatEngineFactory.createJetEngine(model, horsepower, displacement);
                break;
            case "Sterndrive":
                engine = BoatEngineFactory.createSterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = BoatFactory.createRowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = BoatFactory.createSailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistentModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().findByModel(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().findByModel(secondEngineModel);
        Boat boat = BoatFactory.createPowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistentModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().findByModel(engineModel);

        Boat boat = BoatFactory.createYacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = RaceFactory.createRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistentModelException, NoSetRaceException, DuplicateModelException {
        Boat boat = this.database.getBoats().findByModel(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws NoSetRaceException, InsufficientContestantsException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();

        if (participants.size() < 3) {
           throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        Comparator<Boat> timeComparator = (boat1, boat2) -> {
            double time1 =  boat1.calculateRaceSpeed(this.currentRace);
            double time2 =  boat2.calculateRaceSpeed(this.currentRace);
            if (time1 <= 0 && time2 <= 0) {
                return 0;
            }

            return Double.compare(time2, time1);
        };

        participants.sort(timeComparator);

        final int[] index = {0};
        StringBuilder res=new StringBuilder();

        participants.stream().limit(3)
                .forEach(participant->{
                    res.append(String.format("%s place: %s Model: %s Time: %s",
                            POSITIONS[index[0]++], participant.getClass().getSimpleName(),participant.getModel(),
                            participant.calculateRaceSpeed(this.currentRace)<=0.0 ? "Did not finish!" :
                                    String.format("%.2f sec",this.currentRace.getDistance() / participant.calculateRaceSpeed(this.currentRace))
                            ))
                    .append(System.lineSeparator());
                });

        this.currentRace=null;

        return res.toString().trim();
    }

    @Override
    public String getStatistics() {
        StringBuilder res=new StringBuilder();
        List<Boat> participants=this.currentRace.getParticipants();

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

        return res.toString();
    }


    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
