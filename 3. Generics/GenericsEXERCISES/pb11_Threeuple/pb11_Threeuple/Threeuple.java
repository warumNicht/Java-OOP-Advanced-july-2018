package pb11_Threeuple;

public class Threeuple<T,E,N> {
    private T item1;
    private E item2;
    private N item3;

    public Threeuple(T item1, E item2, N item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public void setItem2(E item2) {
        this.item2 = item2;
    }

    public void setItem3(N item3) {
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public E getItem2() {
        return item2;
    }

    public N getItem3() {
        return item3;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(this.item1)
                .append(" -> ")
                .append(this.item2)
                .append(" -> ")
                .append(this.item3);
        return res.toString();
    }
}
