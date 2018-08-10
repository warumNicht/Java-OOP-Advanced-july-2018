package panzer.core;

import panzer.contracts.*;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VehicleManager implements Manager {
    private Map<String,Vehicle> vehicles;
    private Map<String,Vehicle> defeatedVehicles;
    private Map<String,Modelable> allElements;
    private BattleOperator battleOperator;

    public VehicleManager() {
        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
        this.allElements = new LinkedHashMap<>();
        this.battleOperator=new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        Vehicle vehicle=null;

        String vehicleModel=arguments.get(2);
        double weight=Double.parseDouble(arguments.get(3));
        BigDecimal price=new BigDecimal(arguments.get(4));
        int attack=Integer.parseInt(arguments.get(5));
        int defense=Integer.parseInt(arguments.get(6));
        int hitpoints=Integer.parseInt(arguments.get(7));

        switch (arguments.get(1)){
            case "Vanguard":{
                vehicle=new Vanguard(vehicleModel,weight,price,attack,defense,hitpoints);
            }break;
            case "Revenger":{
                vehicle=new Revenger(vehicleModel,weight,price,attack,defense,hitpoints);
            }break;
        }

        this.vehicles.put(vehicle.getModel(),vehicle);
        this.allElements.put(vehicle.getModel(),vehicle);

        return String.format("Created %s Vehicle - %s", vehicle.getClass().getSimpleName(),vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {

        Part part=null;

        String vehicleToAddPart=arguments.get(1);

        String partModel=arguments.get(3);
        double weight=Double.parseDouble(arguments.get(4));
        BigDecimal price=new BigDecimal(arguments.get(5));
        int addProperty=Integer.parseInt(arguments.get(6));

        Vehicle curVehicle=null;
        if(this.vehicles.containsKey(vehicleToAddPart)){
            curVehicle=this.vehicles.get(vehicleToAddPart);
        }else {
            curVehicle=this.defeatedVehicles.get(vehicleToAddPart);
        }

        switch (arguments.get(2)){
            case "Arsenal":{
                part=new ArsenalPart(partModel,weight,price,addProperty);
                curVehicle.addArsenalPart(part);
            }break;
            case "Shell":{
                part=new ShellPart(partModel,weight,price,addProperty);
                curVehicle.addShellPart(part);
            }break;
            case "Endurance":{
                part=new EndurancePart(partModel,weight,price,addProperty);
                curVehicle.addEndurancePart(part);
            }break;
        }
        String partType=part.getClass().getSimpleName().replace("Part","");
        return String.format("Added %s - %s to Vehicle - %s", partType,part.getModel(),curVehicle.getModel());
    }

    @Override
    public String inspect(List<String> arguments) {
        String model=arguments.get(1);
        Modelable element=this.allElements.get(model);

        String res=element.toString();

        return res;
    }

    @Override
    public String battle(List<String> arguments) {
        String attacker=arguments.get(1);
        String target=arguments.get(2);

        Vehicle attackerVehicle=this.vehicles.get(attacker);
        Vehicle targetVehicle=this.vehicles.get(target);

        String winner=this.battleOperator.battle(attackerVehicle,targetVehicle);

        if(winner.equals(attacker)){
            this.defeatedVehicles.put(targetVehicle.getModel(),targetVehicle);
            this.vehicles.remove(target);
        }else {
            this.defeatedVehicles.put(attacker,attackerVehicle);
            this.vehicles.remove(attacker);
        }

        Vehicle winnerVehicle=this.vehicles.get(winner);


        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                attacker, target, winnerVehicle.getModel());
    }

    @Override
    public String terminate(List<String> arguments) {

        int usedpartsCount=0;
        for (Vehicle vehicle : vehicles.values()) {
            for (Part part : vehicle.getParts()) {
                usedpartsCount++;
            }
        }

        StringBuilder res=new StringBuilder();

        res.append(String.format("Remaining Vehicles: %s", this.vehicles.isEmpty() ? "None" : String.join(", ",
                this.vehicles.keySet())))
                .append(System.lineSeparator())
                .append(String.format("Defeated Vehicles: %s", this.defeatedVehicles.isEmpty() ? "None" :
                String.join(", ", this.defeatedVehicles.keySet())))
                .append(System.lineSeparator())
                .append(String.format("Currently Used Parts: %d",usedpartsCount));

        return res.toString();
    }
}
