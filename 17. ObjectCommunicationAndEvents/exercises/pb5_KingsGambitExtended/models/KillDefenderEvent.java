package pb5_KingsGambitExtended.models;


import pb5_KingsGambitExtended.interfaces.KingMediator;
import pb5_KingsGambitExtended.interfaces.Observer;

public class KillDefenderEvent {
    private Observer observer;
    private KingMediator kingMediator;

    public KillDefenderEvent(Observer observer, KingMediator kingMediator) {
        this.observer = observer;
        this.kingMediator = kingMediator;
    }

    public void execute(){
        this.observer.setHealth(this.observer.getHealth()-1);
//        if(this.observer.getHealth()<=0){
//            this.observer.setKilled(true);
//        }
    }
}
