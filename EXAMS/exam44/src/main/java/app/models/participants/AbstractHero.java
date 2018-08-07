package app.models.participants;

import app.contracts.Hero;
import app.models.Config;

public  abstract class AbstractHero extends AbstractParticipant implements Hero {
    private int strength;
    private int  dexterity;
    private int intelligence;


    protected AbstractHero(String name) {
        super(name);
        super.setGold(Config.HERO_START_GOLD);
    }


    @Override
    public void receiveReward(double reward) {
        super.setGold(this.getGold()+reward);
    }

    @Override
    public void levelUp() {
        this.strength*=2;
        this.dexterity*=2;
        this.intelligence*=2;
        super.setHealth(this.strength*Config.HERO_HEALTH_MULTIPLIER);
        super.setLevel(super.getLevel()+1);
    }

//    @Override
//    public double getDamage() {
//        return 0;
//    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength=strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity=dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence=intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }
}
