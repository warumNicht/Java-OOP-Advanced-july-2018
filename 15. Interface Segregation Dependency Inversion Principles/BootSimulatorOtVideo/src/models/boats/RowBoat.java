package models.boats;

import Utility.Validator;
import contracts.Race;

public class RowBoat extends BaseBoat{
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
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
    public double calculateRaceSpeed(Race race) {

        double res=(this.oars*100.0) - super.getWeight()
                +race.getOceanCurrentSpeed();
        return res;
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}
