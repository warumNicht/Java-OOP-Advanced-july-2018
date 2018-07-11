package pb09_CustomListIterator;

import java.util.*;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        this.elements=new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void add(T element){
        this.elements.add(element);
    }
    public T remove(int index){
        return this.elements.remove(index);
    }
    
    public boolean contains(T element){
        return this.elements.contains(element);
    }
    public void print(){
        for (T element : elements) {
            System.out.println(element);
        }
    }
    
    public void swap(int index1,int index2){
        T temp=this.elements.get(index1);
        this.elements.set(index1,this.elements.get(index2));
        this.elements.set(index2,temp);
    }
    
    public  int countGreaterThan(T element){
        int res=0;

        for (T t : this.elements) {
           if(element.compareTo(t)<0){
               res++;
           }
        }
        return res;
    }
    public T getMax(){
        T max=this.elements.get(0);
        for(int i=1; i<this.elements.size(); i++){
            if(max.compareTo(elements.get(i))<0){
                max=elements.get(i);
            }
        }
        return max;
    }
    public T getMin(){
        T min=this.elements.get(0);
        for(int i=1; i<this.elements.size(); i++){
            if(min.compareTo(elements.get(i))>0){
                min=elements.get(i);
            }
        }
        return min;
    }
    public  void sorted(){
        Collections.sort(this.elements);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex=0;

            @Override
            public boolean hasNext() {
                return currentIndex<elements.size();
            }

            @Override
            public T next() {
                return elements.get(currentIndex++);
            }
        };
    }
}
