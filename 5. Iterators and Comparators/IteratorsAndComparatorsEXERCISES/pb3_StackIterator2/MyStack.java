package pb3_StackIterator2;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY=5;
    private T[] elements;
    private int elementsCount;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.elements = (T[])new Object[INITIAL_CAPACITY];
    }

    public void push(T element){
        if(this.elementsCount==this.elements.length){
            growCapacity();
        }
        this.elements[elementsCount++]=element;
    }

    private void growCapacity() {
        this.elements=Arrays.copyOf(this.elements,this.elements.length*2);
    }

    public T pop(){
        if(this.elementsCount==0){
            throw new NoSuchElementException();
        }
        T element=this.elements[--elementsCount];
        this.elements[elementsCount]=null;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private final class MyStackIterator implements Iterator<T> {
        private int cursor;

        public MyStackIterator() {
            this.cursor=elementsCount-1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor>=0;
        }

        @Override
        public T next() {
            return elements[cursor--];
        }
    }
}
