package pb4_BubbleSort;

public class Bubble {
    public static <T extends Comparable<T>> void sort(T[] elements){
        int elementsLength=elements.length;
        for(int i=0; i<elementsLength; i++){
            boolean isSwap=false;
            for (int j = 0; j <elementsLength-i-1 ; j++) {

                if(elements[j].compareTo(elements[j+1])>0){
                    T temp=elements[j];
                    elements[j]=elements[j+1];
                    elements[j+1]=temp;
                    isSwap=true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }
}
