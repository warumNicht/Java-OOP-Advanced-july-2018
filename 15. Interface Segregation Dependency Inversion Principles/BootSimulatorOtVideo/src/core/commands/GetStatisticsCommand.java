package core.commands;

import exeptions.*;

public class GetStatisticsCommand extends BaseCommand {
    @Override
    public String execute()  {
        return super.getController().getStatistics();
    }
}
