package pb05_GenerixCountMethodDoubles;

import java.util.List;

public class Box <T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public static <T extends Comparable<T>> int countGreaterGeneric(List<T>list, T element){

        int res=0;

        for (T t : list) {
            if(element.compareTo(t)<0){
                res++;
            }
        }

        return res;
    }

}
