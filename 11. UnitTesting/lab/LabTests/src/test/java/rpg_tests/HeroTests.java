package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {
    private final static int TARGET_XP=10;
    private final static String HERO_NAME="Stoqn";
    private final static int WEAPON_ATTACK_POINTS=10;
    private final static int WEAPON_DURABILITY_POINTS=10;
    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target fakeTarget=new Target() {
            public int getHealth() {
                return 0;
            }

            public void takeAttack(int attackPoints) {

            }

            public int giveExperience() {
                return TARGET_XP;
            }

            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon=new Weapon() {
            public int getAttackPoints() {
                return 10;
            }

            public int getDurabilityPoints() {
                return 0;
            }

            public void attack(Target target) {

            }
        };

        Hero hero=new Hero(HERO_NAME,fakeWeapon);

        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience",TARGET_XP,hero.getExperience());

    }
    @Test
    public void attackGainsExperienceIfTargetIsDead2(){

        Weapon weaponMock=Mockito.mock(Weapon.class);
        Mockito.when(weaponMock.getDurabilityPoints()).thenReturn(WEAPON_DURABILITY_POINTS);
        Mockito.when(weaponMock.getAttackPoints()).thenReturn(WEAPON_ATTACK_POINTS);

        Target targetMock=Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero=new Hero(HERO_NAME,weaponMock);

        hero.attack(targetMock);
        Assert.assertEquals("Wrong experience",TARGET_XP,hero.getExperience());

    }

}
