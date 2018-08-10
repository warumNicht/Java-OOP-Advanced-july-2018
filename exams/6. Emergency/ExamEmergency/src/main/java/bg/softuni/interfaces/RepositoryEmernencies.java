package bg.softuni.interfaces;

import java.util.List;

public interface RepositoryEmernencies {
    List<Emergency> getEmergencyQueue();

    int getSize();

    void enqueueEmergency(Emergency emergency);

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    Boolean isEmpty();
}
