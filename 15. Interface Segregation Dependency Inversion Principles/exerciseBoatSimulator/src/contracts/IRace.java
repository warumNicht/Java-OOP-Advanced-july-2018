package contracts;

import exeptions.DuplicateModelException;
import models.boats.Boat;

import java.util.List;

public interface IRace
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void AddParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> GetParticipants();
}
