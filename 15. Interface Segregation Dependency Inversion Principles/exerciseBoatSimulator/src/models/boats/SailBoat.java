package models.boats;

import Utility.Constants;
import contracts.IRace;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        super.setMotorBoot(false);
        this.setSailEfficiency(sailEfficiency);

    }
    public int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double res=race.getWindSpeed()*(this.sailEfficiency/100.0) - super.getWeight()
                + race.getOceanCurrentSpeed()/2.0;
        return res;
    }
}
