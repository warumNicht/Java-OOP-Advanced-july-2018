package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;

public abstract class Engine implements IModelable {
    private int cachedOutput;
    private String model;
    private int horsepower;
    private int displacement;

    protected Engine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower( horsepower);
        this.setDisplacement( displacement);
    }

    protected int getCachedOutput() {
        return cachedOutput;
    }

    @Override
    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    protected void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    public abstract int getOutput();
}
