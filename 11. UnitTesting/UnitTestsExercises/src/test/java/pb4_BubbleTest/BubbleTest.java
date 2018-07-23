package pb4_BubbleTest;

import org.junit.Assert;
import org.junit.Test;
import pb4_BubbleSort.Bubble;

public class BubbleTest {
    public static final Integer[] INTEGER_ARRAY_EXAMPLE={5,3,9,7,1};
    @Test
    public void sortingIntegersShouldSortCorrectly(){
        Integer[] expected={1,3,5,7,9};
        Bubble.sort(INTEGER_ARRAY_EXAMPLE);

        Assert.assertArrayEquals(expected,INTEGER_ARRAY_EXAMPLE);
    }

    @Test
    public void sortingStringsShouldSortCorrectly(){
        String[] stringsArray={"dW","a","ab"};
        String[] expected={"a","ab","dW"};
        Bubble.sort(stringsArray);

        Assert.assertArrayEquals(expected,stringsArray);
    }

    @Test
    public void sortingDoublesShouldSortCorrectly(){
        Double[] doublesArray={1.14,0.5,-5.7};
        Double[] expected={-5.7,0.5,1.14};
        Bubble.sort(doublesArray);

        Assert.assertArrayEquals(expected,doublesArray);
    }

    @Test
    public void sortingWithEqualsIntegersShouldSortCorrectly(){
        Integer[] passed={1,1,1,1,1};
        Integer[] expected={1,1,1,1,1};
        Bubble.sort(passed);

        Assert.assertArrayEquals(expected,passed);
    }
    @Test
    public void sortingSortedIntegersShouldSortCorrectly(){
        Integer[] passed={1,2,3,3,5};
        Integer[] expected={1,2,3,3,5};
        Bubble.sort(passed);

        Assert.assertArrayEquals(expected,passed);
    }

    @Test
    public void sortingNull(){
        Integer[] passed=new Integer[3];

        Bubble.sort(passed);

    }
}
