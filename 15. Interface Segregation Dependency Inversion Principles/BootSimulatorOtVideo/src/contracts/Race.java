package contracts;

import exeptions.DuplicateModelException;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}
