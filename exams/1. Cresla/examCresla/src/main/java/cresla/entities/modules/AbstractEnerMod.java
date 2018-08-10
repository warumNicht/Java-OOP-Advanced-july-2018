package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnerMod extends BaseModule implements EnergyModule {
    private int energyOutput;

    protected AbstractEnerMod(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

}
