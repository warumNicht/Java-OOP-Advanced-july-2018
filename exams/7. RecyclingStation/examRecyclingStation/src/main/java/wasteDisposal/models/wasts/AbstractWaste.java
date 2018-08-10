package wasteDisposal.models.wasts;

import wasteDisposal.contracts.Waste;

public abstract class AbstractWaste implements Waste {
    private String name;
    private double weight;
    private double volumePerKg;

    protected AbstractWaste(String...arguments) {
        this.name = arguments[0];
        this.weight = Double.parseDouble(arguments[1]);
        this.volumePerKg = Double.parseDouble(arguments[2]);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
