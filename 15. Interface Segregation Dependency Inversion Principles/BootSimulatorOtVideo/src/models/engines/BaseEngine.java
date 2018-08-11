package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;

public  abstract class BaseEngine implements BoatEngine {
    private String model;
    public int cachedOutput;


    protected BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.validateHorsepower(horsepower);
        this.validateDisplacement(displacement);
        this.cachedOutput=calculateCachedOutput(horsepower,displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }
    @Override
    public int getOutput(){
        return this.cachedOutput;
    }

    protected abstract int calculateCachedOutput(int horsepower, int displacement);

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }


    private void validateHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
    }

    private void validateDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
    }
}
