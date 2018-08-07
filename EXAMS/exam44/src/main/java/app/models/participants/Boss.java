package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends AbstractParticipant  {
    public Boss(String name) {
        super(name);
        super.setGold(Config.BOSS_GOLD);
        super.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void receiveReward(double reward) {
        double decreasedReward=(reward*10.0)/100.0;
        super.setGold(this.getGold()+decreasedReward);
    }
    @Override
    public void giveReward(Targetable targetable) {
        if(this.getGold()>0){
            targetable.receiveReward(this.getGold());
            this.setGold(0);
        }else{
            targetable.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
        }
    }

    @Override
    public void levelUp() {
        super.setHealth(Config.BOSS_HEALTH);
        super.setLevel(super.getLevel()+1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f | %.2f Gold",
                        this.getHealth(), this.getDamage(),this.getGold()));

        return sb.toString();
    }


}
