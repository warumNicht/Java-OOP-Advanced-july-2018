package pb5_KingsGambitExtended.models;

import pb5_KingsGambitExtended.interfaces.Observer;

public abstract class Figure implements Observer {
    private String name;
    private boolean isKilled;
    private int health;

    protected Figure(String name) {
        this.name = name;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
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
