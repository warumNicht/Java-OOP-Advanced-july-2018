package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> implements ExtendedListInterface<T>{

    @Override
    public T max(){
        BiFunction<T,T,Boolean> minimum= (t, t2) -> t.compareTo(t2)<0;
        return this.minOrMax(minimum);
    }
    @Override
    public T min(){
        BiFunction<T,T,Boolean> minimum= (t, t2) -> t.compareTo(t2)>0;
        return this.minOrMax(minimum);
    }
    private T minOrMax(BiFunction<T,T,Boolean> minOrMax){
        T wanted=null;
        Iterator<T> elements=super.iterator();
        while (elements.hasNext()){
            T nextElement=elements.next();
            if(wanted==null||minOrMax.apply(wanted,nextElement)){
                wanted=nextElement;
            }
        }
        return wanted;
    }

    public static void main(String[] args) {
        ExtendedListInterface<Integer> nums=new ExtendedArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(-12);

        System.out.println(nums.min());
        System.out.println(nums.max());
    }

}
