package models.boats;

import contracts.BoatEngine;
import contracts.Race;

public class PowerBoat extends BaseBoat{
    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double res=(this.firstEngine.getOutput()+this.secondEngine.getOutput())
                - super.getWeight() + (race.getOceanCurrentSpeed()/5.0);
        return res;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
