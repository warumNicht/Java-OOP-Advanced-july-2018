package hell.entities.models.heroes;

public class Barbarian extends AbstractHero{
    private static final int BARBARIAN_STRENGTH=90;
    private static final int BARBARIAN_AGILITY=25;
    private static final int BARBARIAN_INTELLIGENCE=10;
    private static final int BARBARIAN_HIT_POINTS=350;
    private static final int BARBARIAN_DAMAGE=150;

    public Barbarian(String name) {
        super(name);
        super.setStrength(BARBARIAN_STRENGTH);
        super.setAgility(BARBARIAN_AGILITY);
        super.setIntelligence(BARBARIAN_INTELLIGENCE);
        super.setHitPoints(BARBARIAN_HIT_POINTS);
        super.setDamage(BARBARIAN_DAMAGE);
    }
}
