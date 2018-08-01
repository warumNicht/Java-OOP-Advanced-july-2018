package proj;

import proj.loggers.Logger;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";


    public Warrior(String id, int dmg, Logger logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getLogger().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    @Override
    public void update(int val) {
        super.getLogger().handle(LogType.EVENT, String.format("%s earns %d",super.getId(), val));
    }
}
