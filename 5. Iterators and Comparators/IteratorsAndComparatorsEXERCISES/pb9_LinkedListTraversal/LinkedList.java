package pb9_LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T>{
    private List<T> elements;

    public LinkedList() {
        this.elements=new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public boolean remove(T element){
        return this.elements.remove(element);
    }

    public int getSize(){
        return this.elements.size();
    }



    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private final class LinkedIterator implements Iterator<T>{

        private  int index;

        public LinkedIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if(this.index<elements.size()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            this.index++;
            return elements.get(this.index-1);
        }
    }
}
