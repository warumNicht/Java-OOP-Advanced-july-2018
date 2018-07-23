package pb7_Hack;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class HackTesting {
    private static final String LINE_SEPARATOR=System.lineSeparator();

    @Test
    public void testMathAbs(){
        Math math=PowerMockito.mock(Math.class);


        int n=math.abs(-5);

        Assert.assertEquals(n,5);
    }
    @Test
    public void testMathFloor(){
        Math math=PowerMockito.mock(Math.class);
        double n=math.floor(3.23);

        Assert.assertTrue(n==3);
    }

    @Test
    public void testSystemLineSeparator() throws Exception {

        System system=PowerMockito.mock(System.class);

       String res=system.lineSeparator();

       Assert.assertEquals(res,LINE_SEPARATOR);
    }
}
