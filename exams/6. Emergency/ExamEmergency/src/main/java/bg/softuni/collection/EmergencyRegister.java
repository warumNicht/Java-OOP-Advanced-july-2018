package bg.softuni.collection;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.RepositoryEmernencies;

import java.util.ArrayList;
import java.util.List;


public class EmergencyRegister implements RepositoryEmernencies {


    private List<Emergency> emergencyQueue;

    public EmergencyRegister() {
        this.emergencyQueue=new ArrayList<>();
    }
    @Override
    public List<Emergency> getEmergencyQueue() {
        return emergencyQueue;
    }

    @Override
    public int getSize(){
        return this.emergencyQueue.size();
    }

    @Override
    public void enqueueEmergency(Emergency emergency) {

        this.emergencyQueue.add(emergency);
    }
    @Override
    public Emergency dequeueEmergency() {
        if(this.emergencyQueue.isEmpty()){
            return null;
        }
        return this.emergencyQueue.remove(0);
    }
    @Override
    public Emergency peekEmergency() {
        Emergency peekedElement = this.emergencyQueue.get(0);
        return peekedElement;
    }
    @Override
    public Boolean isEmpty() {
        return this.emergencyQueue.isEmpty();
    }
}
