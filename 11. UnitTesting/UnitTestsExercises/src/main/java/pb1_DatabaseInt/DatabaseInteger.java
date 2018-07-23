package pb1_DatabaseInt;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseInteger {
    private static final int CAPACITY = 16;
    private  Integer[] elements;
    private int index;

    public DatabaseInteger(Integer...data) throws OperationNotSupportedException {
        this.setElements(data);
        this.index=0;
    }

    private void setElements(Integer... data) throws OperationNotSupportedException {
        if(data.length>CAPACITY){
            throw new OperationNotSupportedException();
        }
        for (Integer integer : data) {
            if(integer==null){
                throw new OperationNotSupportedException();
            }
        }

        this.elements = Arrays.copyOf(data, CAPACITY);

    }

    public void add(Integer element) throws OperationNotSupportedException {
        if(element==null||this.index==CAPACITY){
            throw new OperationNotSupportedException();
        }
        this.elements[index]=element;
        ++this.index;
    }
    public Integer remove() throws OperationNotSupportedException {
        if(this.index<=0||this.elements[this.index-1]==null){
            throw new OperationNotSupportedException();
        }

        Integer res=this.elements[--this.index];
        this.elements[this.index]=null;
        return res;
    }
    public Integer[] fetch(){
        Integer[] res=new Integer[this.index+1];

        if(this.elements[0]!=null){
            for(int i=0; i<this.index; i++){
                res[i]=this.elements[i];
            }
            return res;
        }
        return null;
    }
}
