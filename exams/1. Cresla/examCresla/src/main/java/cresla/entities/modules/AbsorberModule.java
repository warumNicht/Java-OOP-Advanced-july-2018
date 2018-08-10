package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public  abstract class AbsorberModule extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorberModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }


    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("%s Module - %d",this.getClass().getSimpleName(),super.getId()))
                .append(System.lineSeparator());
        res.append(String.format("Heat Absorbing: %d", this.heatAbsorbing));

        return res.toString();
    }
}
