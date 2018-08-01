package pb2_KingsGambit;

import pb2_KingsGambit.interfaces.KingMediator;
import pb2_KingsGambit.interfaces.Observer;

import java.util.LinkedHashMap;

public class King implements KingMediator {
    private String name;
    private LinkedHashMap<String,Observer> defenders;
    private LinkedHashMap<String,Observer> footmans;

    public King(String name) {
        this.name = name;
        this.defenders = new LinkedHashMap<>();
        this.footmans = new LinkedHashMap<>();
    }

    @Override
    public void addGuard(Observer observer) {
        this.defenders.put(observer.getName(),observer);
    }

    @Override
    public void addGFootman(Observer observer) {
        this.footmans.put(observer.getName(),observer);
    }

    @Override
    public void respondToAttack(String name) {
        if(this.defenders.containsKey(name)){
            this.defenders.get(name).kill();
            return;
        }
        if(this.footmans.containsKey(name)){
            this.footmans.get(name).kill();
        }
    }

    @Override
    public void attack() {
        System.out.println(String.format("King %s is under getAttacked!", this.name));
        for (Observer observer : defenders.values()) {
            if(!observer.isKilled()){
                observer.attackKing();
            }
        }
        for (Observer observer : footmans.values()) {
            if(!observer.isKilled()){
                observer.attackKing();
            }
        }
    }
}
