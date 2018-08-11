package core.commands;


import exeptions.DuplicateModelException;

public class CreateBoatEngineCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException {
        return super.getController().createBoatEngine(super.getParams().get(0),Integer.parseInt(super.getParams().get(1)),
                Integer.parseInt(super.getParams().get(2)), super.getParams().get(3)  );
    }
}
