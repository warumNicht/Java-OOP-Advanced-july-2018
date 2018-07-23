import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pb1_DatabaseInt.DatabaseInteger;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class pb1_testingDatabaseIntegers {
    private static final int INITIAL_CAPACITY=16;
    private static final int TEST_ELEMENT=5;
    private static final String DATA_FIELD_NAME = "elements";

    private DatabaseInteger databaseInteger;
    private Integer[] data;
    private Field dataField;

    @Before
    public void initializeObjects() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        this.dataField=DatabaseInteger.class.getDeclaredField(DATA_FIELD_NAME);
        this.dataField.setAccessible(true);

        this.databaseInteger=new DatabaseInteger(INITIAL_CAPACITY);
        this.data=(Integer[]) this.dataField.get(this.databaseInteger);
    }

    // Testing capacity
    @Test
    public void capacityShouldBeEqualToCapacityConstant(){
        Assert.assertEquals(INITIAL_CAPACITY,this.data.length);
    }

    // Testing constructors
    @Test
    public void instantiatingDatabaseWithEmptyConstructorShouldNotThrowException() throws OperationNotSupportedException {
        DatabaseInteger db=new DatabaseInteger();
    }
    @Test
    public void allValuesInAnEmptyDatabaseShouldBeNull() throws OperationNotSupportedException, IllegalAccessException {
        DatabaseInteger db=new DatabaseInteger();
        Integer[] emptyDb=(Integer[]) this.dataField.get(db);
        for(int i=0; i<INITIAL_CAPACITY; i++){
            if(emptyDb[i]!=null){
                throw new IllegalStateException("Value should be null");
            }
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingMoreThanCapacitySizeArgumentsToConstructorShouldThrowException() throws OperationNotSupportedException {
        Integer[] testArray = new Integer[INITIAL_CAPACITY + 1];
        DatabaseInteger db = new DatabaseInteger(testArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingNullValueInConstructorShouldThrowException() throws OperationNotSupportedException {
        DatabaseInteger db = new  DatabaseInteger(TEST_ELEMENT, null, TEST_ELEMENT);
    }

    // Testing element adding

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullObjectShouldThrowException() throws OperationNotSupportedException {
        this.databaseInteger.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingMoreElementsThanCapacityShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < INITIAL_CAPACITY+1; i++) {
            this.databaseInteger.add(TEST_ELEMENT);
        }
    }

    @Test
    public void removeOperationShouldRemoveLastAddedElement() throws OperationNotSupportedException {
        this.databaseInteger.add(TEST_ELEMENT);
        int removedElement = this.databaseInteger.remove();
        Assert.assertEquals(TEST_ELEMENT, removedElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingElementFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        this.databaseInteger.add(TEST_ELEMENT);
        this.databaseInteger.remove();
        this.databaseInteger.remove();
    }
}
