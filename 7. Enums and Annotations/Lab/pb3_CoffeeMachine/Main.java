package pb3_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        CoffeeMachine maschine=new CoffeeMachine();

        while ("END".equals(input)==false){

            if(input.contains(" ")){
                String[]argms=input.split("\\s+");
                maschine.buyCoffee(argms[0],argms[1]);
            }else {
                maschine.insertCoin(input);
            }

            input=reader.readLine();
        }

        Iterable<Coffee> solded=maschine.coffeesSold();

        for (Coffee coffee : solded) {
            System.out.println(coffee);
        }
        
    }
}
