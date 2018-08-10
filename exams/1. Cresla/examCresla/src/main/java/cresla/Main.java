package cresla;

import cresla.entities.ReactorManager;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleReader;
import cresla.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        InputReader reader2=new ConsoleReader();
        OutputWriter writer=new ConsoleWriter();
        Manager manager=new ReactorManager();

        String input=reader.readLine();

        while (true){

            List<String> arguments= Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());
            String commandName=arguments.get(0);
            String res=null;
            switch (commandName){
                case "Reactor":{
                    res=manager.reactorCommand(arguments);
                }break;
                case "Module":{
                    res=manager.moduleCommand(arguments);
                }break;
                case "Report":{
                    res=manager.reportCommand(arguments);
                }break;
                case "Exit":{
                    res=manager.exitCommand(arguments);
                    writer.writeLine(res);
                    return;
                }
            }
            writer.writeLine(res);

            input=reader.readLine();
        }


    }
}
