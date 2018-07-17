package pb8_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstPlayer=reader.readLine();
        String secPlayer=reader.readLine();

        Deck deck=new Deck();

        String[]tokens=null;

        while (deck.getFirstPlayer().size()<5){
            tokens=reader.readLine().split(" of ");
            try {
                Rank curRank=Rank.valueOf(tokens[0]);
                Suite curSuite=Suite.valueOf(tokens[1]);
                Card curCard=new Card(curRank,curSuite);
                deck.addCard(curCard,deck.getFirstPlayer());

            }catch (Exception error){
                System.out.println("No such card exists.");
            }
        }
        while (deck.getSecondPlayer().size()<5){
            tokens=reader.readLine().split(" of ");
            try {
                Rank curRank=Rank.valueOf(tokens[0]);
                Suite curSuite=Suite.valueOf(tokens[1]);
                Card curCard=new Card(curRank,curSuite);
                deck.addCard(curCard,deck.getSecondPlayer());

            }catch (Exception error){
                System.out.println("No such card exists.");
            }
        }
        Card maxPlayerOne=deck.calculateMaxCard(deck.getFirstPlayer());
        Card maxPlayerTwo=deck.calculateMaxCard(deck.getSecondPlayer());


        if(maxPlayerOne.compareTo(maxPlayerTwo)>0){
            System.out.println(String.format("%s wins with %s.",firstPlayer,maxPlayerOne.toString()));
        }else {
            System.out.println(String.format("%s wins with %s.",secPlayer,maxPlayerTwo.toString()));
        }
    }
}
