package pb10_Tuple;

public class Tuple<T,E> {
    private T item1;
    private E item2;

    public Tuple(T item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public E getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(this.item1)
                .append(" -> ")
                .append(this.item2);
        return res.toString();
    }
}
