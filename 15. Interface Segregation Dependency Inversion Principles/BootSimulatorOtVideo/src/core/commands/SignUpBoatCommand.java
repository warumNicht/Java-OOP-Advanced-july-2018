package core.commands;

import exeptions.DuplicateModelException;
import exeptions.NoSetRaceException;
import exeptions.NonExistentModelException;

public class SignUpBoatCommand extends BaseCommand {
    @Override
    public String execute() throws NonExistentModelException, NoSetRaceException, DuplicateModelException {
        return super.getController().signUpBoat(super.getParams().get(0));
    }
}
