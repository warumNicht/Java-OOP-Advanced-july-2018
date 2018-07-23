package pb3_IteratorTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class IteratorTests {
    private static final List<String> INITIAL_LIST=new ArrayList<>() {{
        add("Stefcho");
        add("Goshky");
        add("Coco");
    }};
    private static final List<String> INITIAL_LIST_ONE_ELEMENT=new ArrayList<>() {{
        add("Stefcho");
    }};
    private ListIterator LIST_ITERATOR;
    @Before
    public void initializeTestingObject() throws OperationNotSupportedException {
        this.LIST_ITERATOR=new ListIterator(INITIAL_LIST);
    }

    @Test(expected = OperationNotSupportedException.class )
    public void initializationWithNull() throws OperationNotSupportedException {
        ListIterator current=new ListIterator(null);
    }

    @Test
    public void testIfHasNextElement(){
        boolean res=this.LIST_ITERATOR.hasNext();

        Assert.assertTrue(res==true);
    }
    @Test
    public void testIfHasNotNextElement(){
        this.LIST_ITERATOR.move();
        this.LIST_ITERATOR.move();
        boolean res=this.LIST_ITERATOR.hasNext();

        Assert.assertTrue(res==false);
    }

    @Test
    public void testIfCanMove(){
        boolean res=this.LIST_ITERATOR.move();

        Assert.assertTrue(res==true);
    }

    @Test
    public void testIfCanNotMove(){
        this.LIST_ITERATOR.move();
        this.LIST_ITERATOR.move();
        boolean res=this.LIST_ITERATOR.move();

        Assert.assertTrue(res==false);
    }
    @Test(expected = OperationNotSupportedException.class )
    public void printOnEmpty() throws OperationNotSupportedException {
        ListIterator iterator=new ListIterator();
        iterator.print();
    }


}
