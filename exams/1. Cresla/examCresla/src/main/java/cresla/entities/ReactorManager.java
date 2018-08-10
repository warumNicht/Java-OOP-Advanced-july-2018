package cresla.entities;

import cresla.entities.modules.AbsorberModule;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Identifiable;
import cresla.interfaces.Manager;
import cresla.interfaces.Reactor;

import java.util.HashMap;
import java.util.List;

public class ReactorManager implements Manager {
    private static int idCounter;

    private int cryoReactors=0;
    private int heatReactors=0;
    private int energyModules=0;
    private int absorbingModules=0;

    private long totalEnergyOutput;
    private long totalAbsorbing;

    private HashMap<Integer,Identifiable> allElements;
    private HashMap<Integer,Reactor> reactors;
    public ReactorManager() {
        this.allElements = new HashMap<>();
        this.reactors = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor=null;
        int additionalProperty=Integer.parseInt(arguments.get(2));
        int moduleCapacity=Integer.parseInt(arguments.get(3));
        if("Cryo".equals(arguments.get(1))){
            reactor=new CryoReactor(++idCounter, moduleCapacity,additionalProperty);
        }else {
            reactor=new HeatReactor(++idCounter, moduleCapacity,additionalProperty);
        }

        this.reactors.put(reactor.getId(),reactor);
        this.allElements.put(reactor.getId(),reactor);
        return String.format("Created %s Reactor - %d",
                reactor.getClass().getSimpleName().substring(0,4), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {

        int reactorId=Integer.parseInt(arguments.get(1));
        String type=arguments.get(2);
        int additionalParam=Integer.parseInt(arguments.get(3));

        Reactor reactor=this.reactors.get(reactorId);

        String res=null;

        switch (type){
            case "CryogenRod":{
                EnergyModule module=new CryogenRod(++idCounter,  additionalParam);
                this.allElements.put(module.getId(),module);
                reactor.addEnergyModule(module);
                res= String.format("Added %s - %d to Reactor - %d",
                        module.getClass().getSimpleName(), module.getId(), reactor.getId());
            }break;
            case "HeatProcessor":{
                AbsorberModule module=new HeatProcessor(++idCounter,additionalParam);
                this.allElements.put(module.getId(),module);
                reactor.addAbsorbingModule(module);
                res= String.format("Added %s - %d to Reactor - %d",
                        module.getClass().getSimpleName(), module.getId(), reactor.getId());
            }break;
            case "CooldownSystem":{
                AbsorberModule module=new CooldownSystem(++idCounter,additionalParam);
                this.allElements.put(module.getId(),module);
                reactor.addAbsorbingModule(module);
                res= String.format("Added %s - %d to Reactor - %d",
                        module.getClass().getSimpleName(), module.getId(), reactor.getId());
            }break;

        }

        return res;
    }

    @Override
    public String reportCommand(List<String> arguments) {

        int elementId=Integer.parseInt(arguments.get(1));
        Identifiable element=this.allElements.get(elementId);
        return element.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {

        this.calculateStats();
        this.calculateTotalEnergies();

        StringBuilder res=new StringBuilder();

        res.append(String.format("Cryo Reactors: %d",this.cryoReactors))
                .append(System.lineSeparator())
                .append(String.format("Heat Reactors: %d",this.heatReactors))
                .append(System.lineSeparator())
                .append(String.format("Energy Modules: %d",this.energyModules))
                .append(System.lineSeparator())
                .append(String.format("Absorbing Modules: %d",this.absorbingModules))
                .append(System.lineSeparator())
                .append(String.format("Total Energy Output: %d",this.totalEnergyOutput))
                .append(System.lineSeparator())
                .append(String.format("Total Heat Absorbing: %d",this.totalAbsorbing));

        return res.toString();
    }

    private void calculateStats(){
        int cryoReactors=0;
        int heatReactors=0;
        int energyModules=0;
        int absorbingModules=0;
        for (Identifiable identifiable : allElements.values()) {
            String type=identifiable.getClass().getSimpleName();
            switch (type){
                case "CryoReactor":{
                    cryoReactors++;
                }break;
                case "HeatReactor":{
                    heatReactors++;
                }break;
                case "CryogenRod":{
                    energyModules++;
                }break;
                case "CooldownSystem":{
                    absorbingModules++;
                }break;
                case "HeatProcessor":{
                    absorbingModules++;
                }break;
            }
        }
        this.cryoReactors=cryoReactors;
        this.heatReactors=heatReactors;
        this.energyModules=energyModules;
        this.absorbingModules=absorbingModules;
    }

    private void calculateTotalEnergies(){

        long totalEnergyOutput=0;
        long totalAbsorbing=0;

        for (Reactor reactor : reactors.values()) {
            long currEnery=reactor.getTotalEnergyOutput();
            long currentHeat=reactor.getTotalHeatAbsorbing();
            if(currEnery>currentHeat){
                currEnery=0;
            }

            totalEnergyOutput += currEnery;
            totalAbsorbing+=currentHeat;
        }
        this.totalEnergyOutput=totalEnergyOutput;
        this.totalAbsorbing=totalAbsorbing;
    }
}
