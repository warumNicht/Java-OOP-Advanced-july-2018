package pb2_CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();

        System.out.println(input+":");

        for (Rank card : Rank.values()) {
            System.out.println(card.toString());
        }


    }
}
