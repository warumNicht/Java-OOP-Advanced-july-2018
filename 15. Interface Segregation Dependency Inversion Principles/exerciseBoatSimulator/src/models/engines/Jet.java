package models.engines;

public class Jet extends Engine {
    private static final int Multiplier = 5;

    public Jet(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (super.getCachedOutput() != 0) {
            return super.getCachedOutput();
        }
        int output=(super.getHorsepower()*Multiplier) + super.getDisplacement();
        super.setCachedOutput(output);
        return output;
    }


}
