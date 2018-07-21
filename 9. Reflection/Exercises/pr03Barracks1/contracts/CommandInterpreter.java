package pr03Barracks1.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
