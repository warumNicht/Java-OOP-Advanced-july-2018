package genericsLAB._2_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Object[] strings=ArrayCreator.create(3,"none");
        Integer[] integers=ArrayCreator.create(Integer.class,3,0);
    }
}
