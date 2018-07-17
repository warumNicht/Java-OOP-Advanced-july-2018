package pb7_DeckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                System.out.println(String.format("%s of %s",rank.name(), suite.name()));
            }
        }

    }
}
