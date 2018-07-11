package pb01_02_GenerixBox;

import java.util.List;

public class Box <T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public static <T> void swapGeneric(List<T>list, int firstIndex, int secIndex){
        T temp=list.get(firstIndex);
        list.set(firstIndex,list.get(secIndex));
        list.set(secIndex,temp);


    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.value.getClass().getName(),""+this.value);
    }
}
