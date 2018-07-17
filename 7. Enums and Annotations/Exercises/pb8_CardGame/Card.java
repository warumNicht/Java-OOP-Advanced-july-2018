package pb8_CardGame;

public class Card implements Comparable<Card>{
    private Rank rank;
    private Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }
    private int calculatePower(){
        return this.rank.getPower()+this.suite.getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.rank.name(),this.suite.name() );
    }

    @Override
    public int compareTo(Card o) {
        return this.calculatePower()-o.calculatePower();
    }
}
