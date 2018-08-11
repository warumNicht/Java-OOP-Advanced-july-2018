package engines;

import contracts.CommandHandler;
import contracts.InputReader;
import contracts.OutputWriter;
import contracts.Runnable;
import exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND="End";
    private InputReader reader;
    private OutputWriter writer;
    private CommandHandler commandHandler;

    public Engine(InputReader reader, OutputWriter writer, CommandHandler commandHandler) {
        this.reader = reader;
        this.writer = writer;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run()  {
        while (true) {
              String line = this.reader.readLine();
              List<String> tokens = new ArrayList<>(Arrays.asList(line.split("\\\\")));
              String commName=tokens.get(0);

              if (TERMINATE_COMMAND.equals(commName)) {
                  break;
              }

              try{
                  String result=this.commandHandler.executeCommand(commName,
                          tokens.stream().skip(1).collect(Collectors.toList()));
                  if(result!=null){
                      this.writer.writeLine(result);
                  }
              }catch ( NoSetRaceException | DuplicateModelException | RaceAlreadyExistsException
                      | NonExistentModelException | IllegalAccessException |NoSuchMethodException |
                      InvocationTargetException |IllegalStateException
                      | IllegalArgumentException |InsufficientContestantsException |
                      InstantiationException | ClassNotFoundException e) {

                  this.writer.writeLine(e.getMessage());
              }

        }
    }
}
