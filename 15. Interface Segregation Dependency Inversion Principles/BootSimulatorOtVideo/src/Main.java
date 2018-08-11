import core.CommandHandlerImpl;
import contracts.*;
import controllers.BoatSimulatorControllerImpl;
import database.BoatSimulatorDatabase;
import database.repositories.BoatEngineRepository;
import database.repositories.BoatRepository;
import engines.Engine;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {

        InputReader reader=new ConsoleInputReader();
        OutputWriter writer=new ConsoleOutputWriter();
        CrudRepository<Boat> boats=new BoatRepository<>();
        CrudRepository<BoatEngine> engines=new BoatEngineRepository<>();
        Database database=new BoatSimulatorDatabase(boats,engines);
        BoatSimulatorController controller=new BoatSimulatorControllerImpl(database);
        CommandHandler handler=new CommandHandlerImpl(controller);

        contracts.Runnable engine=new Engine(reader,writer,handler);

        engine.run();

    }
}
