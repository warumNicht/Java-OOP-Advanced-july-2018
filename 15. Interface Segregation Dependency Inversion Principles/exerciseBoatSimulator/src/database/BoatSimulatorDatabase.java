package database;

import contracts.IModelable;
import contracts.IRepository;
import models.boats.Boat;

public class BoatSimulatorDatabase {
    IRepository<Boat> boats;
    IRepository<IModelable> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new Repository<Boat>());
        this.setEngines(new Repository<IModelable>());
    }

    public IRepository<Boat> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<Boat> boats) {
        this.boats = boats;
    }

    public IRepository<IModelable> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<IModelable> engines) {
        this.engines = engines;
    }
}
