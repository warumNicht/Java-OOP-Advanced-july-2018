package pb1_ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator <T>{
    private List<T> elements;
    private int currentPosition;

    public ListyIterator(T[] elements) {
        this.setElements(elements);
        this.currentPosition=0;
    }

    private void setElements(T... elements) {
        this.elements = new ArrayList<>(elements.length);
        if(elements.length>1){
            for(int i=1; i<elements.length; i++){
                this.elements.add(elements[i]);
            }
        }
    }
    public boolean move(){
        if(this.hasNext()){
            this.currentPosition++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if(this.currentPosition<this.elements.size()-1){
            return true;
        }
        return false;
    }
    public void print(){
        if(this.elements.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.elements.get(this.currentPosition));
    }
}
