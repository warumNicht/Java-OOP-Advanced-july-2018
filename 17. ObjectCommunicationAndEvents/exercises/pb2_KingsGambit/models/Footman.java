package pb2_KingsGambit.models;

public class Footman extends Figure {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void attackKing() {
        if(!super.isKilled())
            System.out.println(String.format("Footman %s is panicking!",super.getName()));
    }

}
