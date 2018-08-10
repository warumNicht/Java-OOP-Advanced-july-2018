package cresla.entities.modules;


public class CryogenRod extends AbstractEnerMod {


    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(this.getClass().getSimpleName());
        res.append(super.toString())
                .append(System.lineSeparator());
        res.append(String.format("Energy Output: %d",super.getEnergyOutput()));

        return res.toString();
    }


}
