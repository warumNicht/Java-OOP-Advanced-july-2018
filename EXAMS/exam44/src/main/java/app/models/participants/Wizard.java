package app.models.participants;

import app.models.Config;

public class Wizard extends AbstractHero {
    public Wizard(String name) {
        super(name);
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        super.setHealth(super.getStrength()*Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return this.getIntelligence()*5 + this.getDexterity();
    }
}
