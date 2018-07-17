package pb3_CardswithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank=reader.readLine();

        Rank currRank= Rank.valueOf(rank.toUpperCase());

        String suit=reader.readLine();

        Cards cardColor=Cards.valueOf(suit);

        int power=currRank.getPower()+cardColor.getPower();

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
              currRank.name(),cardColor.name(),power  ));

    }
}
