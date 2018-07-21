package pr0304Barracks.core.commands;

import java.lang.reflect.InvocationTargetException;

public class Report extends Command {


    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String output=super.getRepository().getStatistics();
        return output;
    }
}
