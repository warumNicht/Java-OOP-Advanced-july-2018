package app.models.participants;

import app.contracts.Targetable;

public abstract class AbstractParticipant implements Targetable {
    private String name;
    private double health;
    private double gold;
    private boolean isAlive;
    private int level;

    protected AbstractParticipant(String name) {
        this.name = name;
        this.isAlive = true;
        this.level = 1;
    }

    protected void setGold(double gold) {
        this.gold = gold;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected int getLevel() {
        return this.level;
    }

    @Override
    public String attack(Targetable target) {

        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void takeDamage(double damage) {
        this.health-=damage;
        if(this.health<=0){
            this.isAlive=false;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public abstract double getDamage();

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health=health;
    }
    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
        this.setGold(0);
    }

    @Override
    public void receiveReward(double reward) {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
}
