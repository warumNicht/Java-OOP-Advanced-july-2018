package pb2_KingsGambit.models;

import pb2_KingsGambit.interfaces.Observer;

public abstract class Figure implements Observer {
    private String name;
    private boolean isKilled;

    protected Figure(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isKilled() {
        return isKilled;
    }
    @Override
    public void kill() {
        this.isKilled=true;
    }
}
