package cresla.entities.reactors;

public class HeatReactor extends BaseReactor{
    private  int heatReductionIndex;

    public HeatReactor(int id, int moduleCapacity, int heatReductionIndex) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
        super.setMaxModulesCount(moduleCapacity);
    }


    @Override
    public long getTotalEnergyOutput() {
        long totalEnergy= super.getContainer().getTotalEnergyOutput();
        long totalAbsorbing = this.getTotalHeatAbsorbing();

        if(totalEnergy>totalAbsorbing){
            totalEnergy=0;
        }
        return totalEnergy;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        long totalAbsorbing = super.getContainer().getTotalHeatAbsorbing();
        return totalAbsorbing+this.heatReductionIndex;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(this.getClass().getSimpleName());
        res.append(super.toString())
                .append(System.lineSeparator());

        res.append(String.format("Energy Output: %d", this.getTotalEnergyOutput()))
                .append(System.lineSeparator())
                .append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing()))
                .append(System.lineSeparator())
                .append(String.format("Modules: %d", super.getModuleCount()));

        return res.toString();
    }
}
