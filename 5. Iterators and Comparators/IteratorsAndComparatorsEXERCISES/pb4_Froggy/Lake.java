package pb4_Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake <T> implements Iterable<T>{
    private List<T> elements;

    public Lake(T[] elements) {
        this.setElements(elements);
    }

    private void setElements(T[] elements) {
        this.elements = new ArrayList<>();
        for (T element : elements) {
            this.elements.add(element);
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T element : this) {
            action.accept(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T>{
        private int evenIndex;
        private int oddIndex;

        private Frog() {
            this.evenIndex=0;
            this.oddIndex=1;
        }

        @Override
        public boolean hasNext() {
            if(this.evenIndex<elements.size()||this.oddIndex<elements.size()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(this.evenIndex<elements.size()){
                this.evenIndex+=2;
                return elements.get(this.evenIndex-2);
            }else {
                this.oddIndex+=2;
                return elements.get(this.oddIndex-2);
            }

        }
    }
}
