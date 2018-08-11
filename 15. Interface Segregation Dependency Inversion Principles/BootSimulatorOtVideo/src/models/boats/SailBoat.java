package models.boats;

import Utility.Constants;
import contracts.Race;

public class SailBoat extends BaseBoat{
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double res=(race.getWindSpeed() * (this.sailEfficiency / 100.0)) - super.getWeight() + (race.getOceanCurrentSpeed() / 2.0) ;
        return res;
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}
