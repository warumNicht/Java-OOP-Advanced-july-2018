package pb4_CardtoString;

public class Card {
    private Rank rank;
    private Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    @Override
    public String toString() {
        int power=this.rank.getPower()+this.suite.getPower();
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(),this.suite.name(),power  );
    }
}
