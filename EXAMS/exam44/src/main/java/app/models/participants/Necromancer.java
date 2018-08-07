package app.models.participants;

import app.models.Config;

public class Necromancer extends AbstractHero {
    public Necromancer(String name) {
        super(name);
        super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
        super.setHealth(super.getStrength()*Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return this.getIntelligence()*2 +
                this.getDexterity()*2 + this.getStrength()*2;
    }
}
