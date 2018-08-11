package core.commands;

import exeptions.*;

public class StartRaceCommand extends BaseCommand {
    @Override
    public String execute() throws InsufficientContestantsException, NoSetRaceException {
        return super.getController().startRace();
    }
}
