package app;

import app.contracts.ActionFactory;
import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.TargetableFactory;
import app.core.BattlefieldImplementation;
import app.core.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        TargetableFactory targetableFactory=new TargetableFactoryImpl();
        ActionFactory actionFactory=new ActionFactoryImpl();
        Battlefield battleField = new BattlefieldImplementation(writer,targetableFactory,actionFactory);

        Engine engine=new EngineImpl(reader,battleField);
        engine.run();


    }
}
