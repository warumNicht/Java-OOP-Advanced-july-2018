package pb08_CustomListSorter;

public class Sorter {
    public Sorter() {
    }

    public static <T extends Comparable<T>> void   sort (CustomList<T> list){
        list.sorted();
    }
}
