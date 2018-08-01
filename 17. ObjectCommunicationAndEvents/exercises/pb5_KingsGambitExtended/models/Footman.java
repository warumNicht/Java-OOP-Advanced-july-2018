package pb5_KingsGambitExtended.models;

public class Footman extends Figure {
    public static final int HEALTH_FOOTMAN=2;
    public Footman(String name) {
        super(name);
        super.setHealth(HEALTH_FOOTMAN);
    }

    @Override
    public void attackKing() {
        if(!super.isKilled())
            System.out.println(String.format("Footman %s is panicking!",super.getName()));
    }

}
