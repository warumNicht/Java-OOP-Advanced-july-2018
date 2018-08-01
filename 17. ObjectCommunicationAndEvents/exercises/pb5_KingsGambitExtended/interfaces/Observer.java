package pb5_KingsGambitExtended.interfaces;

public interface Observer {
    void attackKing();

    int getHealth();

    void setHealth(int health);

    String getName();
    boolean isKilled();
    void kill();
}
