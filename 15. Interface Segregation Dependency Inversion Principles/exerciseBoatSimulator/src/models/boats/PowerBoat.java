package models.boats;

import contracts.IRace;
import models.engines.Engine;

public class PowerBoat extends Boat {
    private Engine engine1;
    private Engine engine2;

    public PowerBoat(String model, int weight, Engine engine1, Engine engine2) {
        super(model, weight);
        this.engine1=engine1;
        this.engine2=engine2;
    }


    @Override
    public double calculateRaceSpeed(IRace race) {
        double res= this.engine1.getOutput()+this.engine2.getOutput()
                - super.getWeight() + race.getOceanCurrentSpeed()/5.0;
        return res;
    }
}
