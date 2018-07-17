package pb5_CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank=reader.readLine();
        Rank currRank1= Rank.valueOf(rank.toUpperCase());
        String suit=reader.readLine();
        Suite cardColor1=Suite.valueOf(suit);

        Card card1=new Card(currRank1,cardColor1);

        rank=reader.readLine();
        Rank currRank2= Rank.valueOf(rank.toUpperCase());
        suit=reader.readLine();
        Suite cardColor2=Suite.valueOf(suit);

        Card card2=new Card(currRank2,cardColor2);


        if(card1.compareTo(card2)>=0){
            System.out.println(card1.toString());
        }else {
            System.out.println(card2.toString());
        }
    }
}
