package bg;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.interfaces.Manager;
import bg.softuni.interfaces.RepositoryEmernencies;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;
import bg.softuni.io.InputReader;
import bg.softuni.io.OutputWriter;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        InputReader reader=new ConsoleReader();
        OutputWriter writer=new ConsoleWriter();

        Manager manager=new EmergencyManagementSystem();

        String input=reader.readLine();

        while (true){
            String[]tokens=input.split("\\|");
            String res=null;

            switch (tokens[0]){
                case "RegisterPropertyEmergency":{
                    res=manager.registerPropertyEmergency(tokens);
                }break;
                case "RegisterHealthEmergency":{
                    res=manager.registerHealthEmergency(tokens);
                }break;
                case "RegisterOrderEmergency":{
                    res=manager.registerOrderEmergency(tokens);
                }break;
                case "RegisterFireServiceCenter":{
                    res=manager.registerFireServiceCenter(tokens);
                }break;
                case "RegisterMedicalServiceCenter":{
                    res=manager.registerMedicalServiceCenter(tokens);
                }break;
                case "RegisterPoliceServiceCenter":{
                    res=manager.registerPoliceServiceCenter(tokens);
                }break;
                case "ProcessEmergencies":{
                    res=manager.processEmergencies(tokens);
                }break;
                case "EmergencyReport":{
                    res=manager.emergencyReport();
                }break;
                case "EmergencyBreak":{
                        return;
                }
            }
            if(res!=null)
                writer.writeLine(res);

            input=reader.readLine();
        }
    }
}
