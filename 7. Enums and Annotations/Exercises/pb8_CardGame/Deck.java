package pb8_CardGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Deck {
    private List<Card> firstPlayer;
    private List<Card> secondPlayer;
    private HashSet<String> passedCards;

    public Deck() {
        this.firstPlayer=new ArrayList<>();
        this.secondPlayer=new ArrayList<>();
        this.passedCards=new HashSet<>();
    }

    public void addCard(Card card,List<Card> playerCards){
        if(this.passedCards.contains(card.toString())){
            System.out.println("Card is not in the deck.");
        }else {
            playerCards.add(card);
            this.passedCards.add(card.toString());
        }
    }

    public List<Card> getFirstPlayer() {
        return firstPlayer;
    }

    public List<Card> getSecondPlayer() {
        return secondPlayer;
    }

    public Card calculateMaxCard(List<Card> playerHand){
        Card max=playerHand.get(0);

        for(int i=1; i<playerHand.size(); i++){
            if(playerHand.get(i).compareTo(max)>0){
                max=playerHand.get(i);
            }
        }
        return max;
    }
}
