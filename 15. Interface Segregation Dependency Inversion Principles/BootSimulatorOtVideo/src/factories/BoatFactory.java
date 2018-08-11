package factories;

import contracts.Boat;
import contracts.BoatEngine;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;

public final class BoatFactory {
    private BoatFactory() {
    }

    public static Boat createRowBoat(String model, int weight, int oars){
        return new RowBoat(model,weight,oars);
    }
    public static Boat createSailBoat(String model, int weight, int sailEfficiency){
        return new SailBoat(model,weight,sailEfficiency);
    }
    public static Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine){
        return new PowerBoat(model,weight,firstEngine,secondEngine);
    }
    public static Boat createYacht(String model, int weight, BoatEngine firstEngine,  int cargoWeight){
        return new Yacht(model,weight,firstEngine,cargoWeight);
    }
}
