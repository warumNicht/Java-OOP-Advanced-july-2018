package pb4_CardtoString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank=reader.readLine();
        Rank currRank= Rank.valueOf(rank.toUpperCase());

        String suit=reader.readLine();
        Suite cardColor=Suite.valueOf(suit);

        Card card=new Card(currRank,cardColor);

        System.out.println(card.toString());


    }
}
