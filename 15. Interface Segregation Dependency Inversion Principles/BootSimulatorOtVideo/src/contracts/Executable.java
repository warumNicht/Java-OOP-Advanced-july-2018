package contracts;

import exeptions.*;

public interface Executable  {
    String execute() throws DuplicateModelException, NonExistentModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
