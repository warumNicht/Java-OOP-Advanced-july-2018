package database;

import contracts.*;

import java.util.Map;

public class BoatSimulatorDatabase implements Database{
    private CrudRepository<Boat> boats;
    private CrudRepository<BoatEngine> engines;

    public BoatSimulatorDatabase(CrudRepository<Boat> boats, CrudRepository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }
    @Override
    public CrudRepository<Boat> getBoats() {
        return boats;
    }
    @Override
    public CrudRepository<BoatEngine> getEngines() {
        return engines;
    }

}
