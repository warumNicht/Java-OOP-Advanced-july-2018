package pb2_TestsDatabasePerson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pb2_DatabasePerson.Database;
import pb2_DatabasePerson.People;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final int INITIAL_CAPACITY=16;
    private static final People EXAMPLE_VALUE=new People("Stoqn",23);
    private Database database;
    @Before
    public void initializeObjects() throws OperationNotSupportedException {
        this.database=new Database(INITIAL_CAPACITY);
    }

    @Test(expected = OperationNotSupportedException.class) //Assert
    public void testCreatingDatabase() throws OperationNotSupportedException {

        Database database=new Database(INITIAL_CAPACITY-1);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryAddNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void tryAddMoreElementsThenSize() throws OperationNotSupportedException {
        for(int i=0; i<INITIAL_CAPACITY+1; i++){
            People current=new People("Ivan"+i,i+1);
            this.database.add(current);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryAddPeopleWithSameUserName() throws OperationNotSupportedException {

        People current=new People("Ivan",50);
        this.database.add(current);
        current=new People("Ivan",40);
        this.database.add(current);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryAddPeopleWithSameId() throws OperationNotSupportedException {

        People current=new People("Ivan",50);
        this.database.add(current);
        current=new People("Pesho",50);
        this.database.add(current);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        this.database.remove();
    }

    @Test
    public void tryRemoveElementFromNonemptyDatabase() throws OperationNotSupportedException {
        this.database.add(EXAMPLE_VALUE);
        People removed=this.database.remove();
        int res=EXAMPLE_VALUE.compareTo(removed);
        Assert.assertEquals(0,res);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void tryFindByNullUserName() throws OperationNotSupportedException {
        this.database.add(EXAMPLE_VALUE);
        this.database.findByUserName(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryFindByInvalidUserName() throws OperationNotSupportedException {
        this.database.add(EXAMPLE_VALUE);
        this.database.findByUserName("Tosho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryFindByInvalidId() throws OperationNotSupportedException {
        this.database.add(EXAMPLE_VALUE);
        this.database.findById(5);
    }
}
