package Core;

import contracts.ICommandHandler;
import exeptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private ICommandHandler commandHandler; //ed

    public Engine(ICommandHandler commandHandler) //ed
    {
        this.commandHandler = commandHandler;
    }

    public Engine() {
        this.commandHandler = new CommandHandler();
    }

    // public ICommandHandler getCommandHandler;

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (true) {

            String name = "";
            List<String> parameters = new ArrayList<>();

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                String commandResult = this.commandHandler.ExecuteCommand(name, parameters);
                System.out.println(commandResult);
            } catch (NoSetRaceException | DuplicateModelException | RaceAlreadyExistsException
                    | NonExistantModelException
                    | IllegalArgumentException | InsufficientContestantsException e) {
                System.out.println(e.getMessage());
            }

            line = scanner.nextLine();
        }
    }

}
