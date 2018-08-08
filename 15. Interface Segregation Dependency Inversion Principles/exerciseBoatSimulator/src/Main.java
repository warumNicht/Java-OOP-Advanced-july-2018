import Core.CommandHandler;
import Core.Engine;
import contracts.IBoatSimulatorController;
import contracts.ICommandHandler;
import controllers.BoatSimulatorController;

public class Main {
    public static void main(String[] args) {

        IBoatSimulatorController controller=new BoatSimulatorController();

        ICommandHandler commandHandler = new CommandHandler(controller);//add I
        Engine engine = new Engine(commandHandler);
        engine.Run();

    }
}
