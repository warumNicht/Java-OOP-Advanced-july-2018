package pb5_KingsGambitExtended.interfaces;

public interface KingMediator {
    void addDefender(Observer observer);
    void killAttacker(String name);
    void getAttacked();
}
