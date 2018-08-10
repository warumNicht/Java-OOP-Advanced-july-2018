package bg.softuni.collection;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.RepositoryEmernencies;

import java.util.List;


public class EmergencyRegister2 implements RepositoryEmernencies {

    private static final Integer INITIAL_SIZE = 16;

    private Emergency[] emergencyQueue;

    private Integer currentSize;

    private Integer nextIndex;

    public EmergencyRegister2() {
        this.emergencyQueue = new Emergency[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    @Override
    public List<Emergency> getEmergencyQueue() {
        return null;
    }

    @Override
    public int getSize(){
        return this.currentSize;
    }

    private void resize() {
        Emergency[] newArray = new Emergency[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }
    @Override
    public void enqueueEmergency(Emergency emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }
    @Override
    public Emergency dequeueEmergency() {
        Emergency removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize ; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }
    @Override
    public Emergency peekEmergency() {
        Emergency peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }
    @Override
    public Boolean isEmpty() {
        return this.currentSize == 0;
    }
}
