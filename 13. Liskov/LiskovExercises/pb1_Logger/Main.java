package pb1_Logger;

import pb1_Logger.enums.ReportLevel;
import pb1_Logger.interfaces.Appender;
import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.Controller;
import pb1_Logger.models.Message;
import pb1_Logger.models.appenders.ConsoleAppender;
import pb1_Logger.models.appenders.FileAppender;
import pb1_Logger.models.layouts.SimpleLayout;
import pb1_Logger.models.layouts.XmlLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Controller controller=new Controller();

        int n=Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){

            controller.addAppender(reader.readLine());
        }
        controller.setLogger();

        String input=reader.readLine();
        while ("END".equals(input)==false){
            String[] tokens=input.split("\\|");
            Message message=new Message(ReportLevel.valueOf(tokens[0].toUpperCase()), tokens[1],tokens[2]);

            controller.loggingMessage(message);

            input=reader.readLine();
        }

        controller.printStatistics();




    }
}
