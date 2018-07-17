package pb3_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coin> coins;
    private List<Coffee> coffeesSold;

    public CoffeeMachine() {
        this.coins=new ArrayList<>();
        this.coffeesSold=new ArrayList<>();
    }

    public void insertCoin(String coin){
        Coin curCoin=Coin.valueOf(coin.toUpperCase());
        this.coins.add(curCoin);
    }
    public Iterable<Coffee> coffeesSold(){
        return this.coffeesSold;

    }

    public void buyCoffee(String size,String type){
        CoffeeSize currSize=CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType currType=CoffeeType.valueOf(type.toUpperCase());
        Coffee coffee=new Coffee(currSize,currType);

        int currentSum=this.coins.stream()
                .mapToInt(Coin::getValue)
                .sum();
        if(currentSum>coffee.getPrice()){
            this.coffeesSold.add(coffee);
            this.coins.clear();
        }
    }
}
