package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
	private static final String COMMAND_PATH="pr0304Barracks.core.commands.";

	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter interpreter;

	public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.interpreter=interpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable command = this.interpreter.interpretCommand( commandName);
				this.data= data;
				this.injectDependencies(command);
				String result=command.execute();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	private void injectDependencies(Executable command) throws IllegalAccessException {
		Field[] fields=command.getClass().getSuperclass()
				.getDeclaredFields();
		Field[] enginFields=this.getClass().getDeclaredFields();

		for (Field commandField : fields) {
			if(commandField.isAnnotationPresent(Inject.class)){
				for (Field enginField : enginFields) {
					if(commandField.getType().equals(enginField.getType())
							&& commandField.getName().equals(enginField.getName())){
						commandField.setAccessible(true);
						enginField.setAccessible(true);
						commandField.set(command,enginField.get(this));

					}
				}

			}
		}

	}

}
