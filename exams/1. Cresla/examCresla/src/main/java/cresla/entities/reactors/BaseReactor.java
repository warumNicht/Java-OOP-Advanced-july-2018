package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;
    private int modulesCount;
    private int maxModulesCount;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    protected void setMaxModulesCount(int maxModulesCount) {
        this.maxModulesCount = maxModulesCount;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    public int getModuleCount() {
        return this.modulesCount;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
        if(this.modulesCount<this.maxModulesCount){
            this.modulesCount++;
        }
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
        if(this.modulesCount<this.maxModulesCount){
            this.modulesCount++;
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format(" - %d",this.id);
    }
}
