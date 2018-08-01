package pb1_EventImplementation;

import pb1_EventImplementation.events.Event;
import pb1_EventImplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.add(listener);
    }
    public void removeNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.remove(listener);
    }

    public void fireNameChangeEvent(Event event){
        this.name=event.getChangedName();
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }
}
