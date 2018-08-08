package models.boats;

import Utility.Validator;
import contracts.IRace;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        super.setMotorBoot(false);
        this.setOars(oars);
    }

    public int getOars() {
        return oars;
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double res=(this.oars*100.0) - super.getWeight() + race.getOceanCurrentSpeed();
        return res;
    }
}
