package pb2_KingsGambit.interfaces;

public interface KingMediator {
    void addGuard(Observer observer);
    void addGFootman(Observer observer);
    void respondToAttack(String name);
    void attack();
}
