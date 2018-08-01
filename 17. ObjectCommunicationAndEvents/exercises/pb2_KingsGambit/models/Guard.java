package pb2_KingsGambit.models;

public class Guard extends Figure {
    public Guard(String name) {
        super(name);
    }

    @Override
    public void attackKing() {
        if(!super.isKilled())
        System.out.println(String.format("Royal Guard %s is defending!",super.getName()));
    }


}
