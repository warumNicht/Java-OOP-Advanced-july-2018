package pb1_Logger.models;

import pb1_Logger.interfaces.Appender;
import pb1_Logger.interfaces.Layout;
import pb1_Logger.interfaces.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private static final String PATH_TO_LAYOUTS="pb1_Logger.models.layouts.";
    private static final String PATH_TO_APPENDERS="pb1_Logger.models.appenders.";

    private List<Appender> appenders;
    private Logger logger;

    public Controller() {
        this.appenders = new ArrayList<>();
    }
    public void addAppender(String input) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[]tokens=input.split("\\s+");

        Class layoutClass=Class.forName(PATH_TO_LAYOUTS+tokens[1]);
        Constructor ctrLayout=layoutClass.getConstructors()[0];
        Layout curLayout= (Layout) ctrLayout.newInstance();

        Class appederClass=Class.forName(PATH_TO_APPENDERS+tokens[0]);
        Constructor crtAppender=appederClass.getConstructors()[0];
        Appender curAppender= (Appender) crtAppender.newInstance(curLayout);

        if(tokens.length>2){
            curAppender.setReportLevel(tokens[2]);
        }
        this.appenders.add(curAppender);
    }
    public void setLogger(){
        this.logger=new MessageLogger( this.appenders.toArray(new Appender[this.appenders.size()]));
    }
    public void loggingMessage(Message message){
        this.logger.logMessage(message);
    }
    public void printStatistics(){
        System.out.println("Logger info");
        this.logger.getInfo();
    }
}
