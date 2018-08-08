package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;
import contracts.IRace;

public abstract class Boat implements IModelable {
    private String model;
    private int weight;
    private boolean isMotorBoot;

    protected Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
        this.isMotorBoot=true;
    }

    public boolean isMotorBoot() {
        return isMotorBoot;
    }

    protected void setMotorBoot(boolean motorBoot) {
        isMotorBoot = motorBoot;
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
    public abstract double calculateRaceSpeed(IRace race);
}
