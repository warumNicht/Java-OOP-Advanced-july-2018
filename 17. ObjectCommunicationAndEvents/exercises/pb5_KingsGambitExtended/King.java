package pb5_KingsGambitExtended;

import pb5_KingsGambitExtended.interfaces.KingMediator;
import pb5_KingsGambitExtended.interfaces.Observer;
import pb5_KingsGambitExtended.models.KillDefenderEvent;

import java.util.LinkedHashMap;

public class King implements KingMediator {
    private String name;
    private LinkedHashMap<String,Observer> defenders;

    public King(String name) {
        this.name = name;
        this.defenders = new LinkedHashMap<>();
    }

    @Override
    public void addDefender(Observer observer) {
        this.defenders.put(observer.getName(),observer);
    }


    @Override
    public void killAttacker(String name) {
        if(this.defenders.containsKey(name)){
            Observer observer=this.defenders.get(name);
            KillDefenderEvent event=new KillDefenderEvent(observer,this);
            event.execute();
            if(observer.getHealth()<=0){
                this.defenders.get(name).kill();
            }

        }
    }

    @Override
    public void getAttacked() {
        System.out.println(String.format("King %s is under attack!", this.name));
        for (Observer observer : defenders.values()) {
            if(!observer.isKilled()){
                observer.attackKing();
            }
        }
    }
}
