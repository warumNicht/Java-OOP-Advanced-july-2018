package factories;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Race;
import models.RaceImpl;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;

public final class RaceFactory {
    private RaceFactory() {
    }

    public static Race createRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats){
        return new RaceImpl(distance,windSpeed,oceanCurrentSpeed,allowsMotorboats);
    }

}
