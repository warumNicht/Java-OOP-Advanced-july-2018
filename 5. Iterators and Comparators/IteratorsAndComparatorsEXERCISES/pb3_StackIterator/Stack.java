package pb3_StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack <T>implements Iterable<T> {
    private List<T> elements;

    public Stack() {
        this.elements=new ArrayList<>();
    }

    public void push(T element) {
        this.elements.add(element);
    }


    public void pop(){
        if(this.elements.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }
        this.elements.remove(this.elements.size()-1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private final class StackIterator implements Iterator<T>{
        private int index;

        public StackIterator() {
            this.index = elements.size();
        }

        @Override
        public boolean hasNext() {
            if(this.index>0){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return elements.get(--this.index);
        }
    }
}
