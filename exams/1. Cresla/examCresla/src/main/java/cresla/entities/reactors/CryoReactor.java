package cresla.entities.reactors;

public class CryoReactor extends BaseReactor {
    private  int cryoProductionIndex;

    public CryoReactor(int id, int moduleCapacity, int cryoProductionIndex) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
        super.setMaxModulesCount(moduleCapacity);
    }


    @Override
    public long getTotalEnergyOutput() {
        long totalEnergy= super.getContainer().getTotalEnergyOutput();
        long totalAbsorbing = super.getContainer().getTotalHeatAbsorbing();

        totalEnergy*=this.cryoProductionIndex;
        if(totalEnergy>totalAbsorbing){
            totalEnergy=0;
        }
        return totalEnergy;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        long totalAbsorbing = super.getContainer().getTotalHeatAbsorbing();
        return totalAbsorbing;
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
