package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int DUMMY_HEALTH=10;
    private static final int DUMMY_DEATH_HEALTH=0;
    private static final int DUMMY_XP=10;
    private Dummy aliveDummy;
    private Dummy deathDummy;

    @Before
    public void initializeTestObjects(){
        this.aliveDummy=new Dummy(DUMMY_HEALTH,DUMMY_XP);
        this.deathDummy=new Dummy(DUMMY_DEATH_HEALTH,DUMMY_XP);
    }

    @Test
    public void losesHealthOnAttacked(){

        this.aliveDummy.takeAttack(5);

        Assert.assertEquals("Not losing health",this.aliveDummy.getHealth(),5);
    }

    @Test (expected = IllegalStateException.class)
    public void throwsExeptionIfDead(){

        this.deathDummy.takeAttack(10);
    }
    @Test
    public void deadCanGiveXP(){


        int exp=this.deathDummy.giveExperience();

        Assert.assertEquals(10,exp);
    }
    @Test(expected = IllegalStateException.class)
    public void deadCantGiveXP(){

        int exp=this.aliveDummy.giveExperience();
    }

}
