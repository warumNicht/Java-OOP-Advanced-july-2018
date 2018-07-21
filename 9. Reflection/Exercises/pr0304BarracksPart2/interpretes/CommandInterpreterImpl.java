package pr0304Barracks.interpretes;

import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PATH="pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl( Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String result=COMMAND_PATH+Character.toUpperCase(commandName.charAt(0))+commandName.substring(1);
        Class<?> curClaz;
        try{
            curClaz=Class.forName(result);
        }catch (ClassNotFoundException ex){
            throw new RuntimeException("Invalid command!");
        }
        Constructor<?> constructor=curClaz.getConstructor(String[].class,Repository.class,UnitFactory.class);

        Executable curCommand=(Executable) constructor.newInstance(data,this.repository,this.unitFactory);

        return curCommand;
    }
}
