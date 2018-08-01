package pb5_KingsGambitExtended.models;

public class Guard extends Figure {
    public static final int HEALTH_GUARD=3;
    public Guard(String name) {
        super(name);
        super.setHealth(HEALTH_GUARD);
    }

    @Override
    public void attackKing() {
        if(!super.isKilled())
        System.out.println(String.format("Royal Guard %s is defending!",super.getName()));
    }


}
