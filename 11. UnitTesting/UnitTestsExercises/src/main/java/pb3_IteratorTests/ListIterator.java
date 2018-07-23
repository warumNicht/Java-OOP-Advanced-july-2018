package pb3_IteratorTests;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIterator {
    private List<String> elements;
    private int index;

    public ListIterator() {
    }

    public ListIterator(List<String> elements) throws OperationNotSupportedException {
        this.setElements(elements);
        this.index=0;
    }

    private void setElements(List<String> elements) throws OperationNotSupportedException {
        if(elements==null){
            throw new OperationNotSupportedException();
        }
        this.elements = elements;
    }

    public boolean hasNext(){
        return this.index<this.elements.size()-1;
    }
    public boolean move(){
        if(this.hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    public void print() throws OperationNotSupportedException {
        if(this.elements==null){
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        System.out.println(this.elements.get(this.index));
    }


}
