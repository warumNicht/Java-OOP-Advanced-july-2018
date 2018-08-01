package pb1_EventImplementation;

import pb1_EventImplementation.events.Event;
import pb1_EventImplementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener {
    @Override
    public void handleChangedName(Event event) {
        System.out.println(String.format("Dispatcher's name changed to %s.",event.getChangedName()));
    }
}
