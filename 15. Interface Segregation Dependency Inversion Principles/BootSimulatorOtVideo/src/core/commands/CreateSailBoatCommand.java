package core.commands;

import exeptions.DuplicateModelException;

public class CreateSailBoatCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException {
        return super.getController().createSailBoat(super.getParams().get(0),Integer.parseInt(super.getParams().get(1)),
                Integer.parseInt(super.getParams().get(2)) );
    }
}
