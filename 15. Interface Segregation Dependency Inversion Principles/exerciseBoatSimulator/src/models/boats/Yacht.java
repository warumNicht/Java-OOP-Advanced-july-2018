package models.boats;

import Utility.Validator;
import contracts.IRace;
import models.engines.Engine;

public class Yacht extends Boat {
    private int cargoWeight;
    private Engine engine;

    public Yacht(String model, int weight, int cargoWeight,Engine engine) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.engine=engine;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double res= this.engine.getOutput() -( super.getWeight()+this.cargoWeight)
                + race.getOceanCurrentSpeed()/2.0;
        return res;
    }
}
