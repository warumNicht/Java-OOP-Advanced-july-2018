package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.VehicleManager;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader=new ConsoleReader();
        OutputWriter writer=new ConsoleWriter();
        Manager manager=new VehicleManager();

        String input=reader.readLine();
        while (true){
            String[]tokens=input.split("\\s+");
            String res=null;
            List<String> arguments= Arrays.asList(tokens);

            switch (tokens[0]){
                case "Vehicle":{
                    res=manager.addVehicle(arguments);
                }break;
                case "Part":{
                    res=manager.addPart(arguments);
                }break;
                case "Battle":{
                    res=manager.battle(arguments);
                }break;
                case "Inspect":{
                    res=manager.inspect(arguments);
                }break;
                case "Terminate":{
                    res=manager.terminate(arguments);
                    writer.println(res);
                    return;
                }
            }
            if(res!=null)
                writer.println(res);

            input=reader.readLine();
        }

        
    }
}
