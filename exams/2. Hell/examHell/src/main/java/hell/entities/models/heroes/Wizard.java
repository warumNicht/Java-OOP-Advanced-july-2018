package hell.entities.models.heroes;

public class Wizard extends AbstractHero{
    private static final int WIZARD_STRENGTH=25;
    private static final int WIZARD_AGILITY=25;
    private static final int WIZARD_INTELLIGENCE=100;
    private static final int WIZARD_HIT_POINTS=100;
    private static final int WIZARD_DAMAGE=250;

    public Wizard(String name) {
        super(name);
        super.setStrength(WIZARD_STRENGTH);
        super.setAgility(WIZARD_AGILITY);
        super.setIntelligence(WIZARD_INTELLIGENCE);
        super.setHitPoints(WIZARD_HIT_POINTS);
        super.setDamage(WIZARD_DAMAGE);
    }
}
