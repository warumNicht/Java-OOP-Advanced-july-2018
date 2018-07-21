package pr0304Barracks.core.commands;


import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {


    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            super.getRepository().removeUnit(super.getData()[1]);
            return String.format("%s retired!",super.getData()[1]);
        }catch (IllegalArgumentException error){
            return error.getMessage();
        }
    }
}
