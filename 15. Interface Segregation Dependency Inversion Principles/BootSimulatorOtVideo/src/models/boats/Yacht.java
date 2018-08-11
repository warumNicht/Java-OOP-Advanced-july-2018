package models.boats;

import Utility.Validator;
import contracts.BoatEngine;
import contracts.Race;

public class Yacht extends BaseBoat{
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }
    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double res=this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2.0);
        return res;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
