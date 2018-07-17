package pb3_CoffeeMachine;

public enum CoffeeSize {
    SMALL(50,50),
    NORMAL(100,75),
    DOUBLE(200,100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
