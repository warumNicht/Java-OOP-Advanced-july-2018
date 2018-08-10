package hell.entities.models.heroes;

public class Assassin extends AbstractHero{
    private static final int ASSASSIN_STRENGTH=25;
    private static final int ASSASSIN_AGILITY=100;
    private static final int ASSASSIN_INTELLIGENCE=15;
    private static final int ASSASSIN_HIT_POINTS=150;
    private static final int ASSASSIN_DAMAGE=300;

    public Assassin(String name) {
        super(name);
        super.setStrength(ASSASSIN_STRENGTH);
        super.setAgility(ASSASSIN_AGILITY);
        super.setIntelligence(ASSASSIN_INTELLIGENCE);
        super.setHitPoints(ASSASSIN_HIT_POINTS);
        super.setDamage(ASSASSIN_DAMAGE);
    }
}
