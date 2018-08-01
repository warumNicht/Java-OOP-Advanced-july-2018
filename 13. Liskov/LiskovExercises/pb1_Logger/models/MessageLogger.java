package pb1_Logger.models;

import pb1_Logger.interfaces.Appender;
import pb1_Logger.interfaces.Logger;

import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }
    private void setAppenders(Appender... appenders){
       this.appenders=Arrays.asList(appenders);
    }

    @Override
    public void logMessage(Message message) {
        for (Appender appender : appenders) {
            appender.appendMessage(message);
        }
    }

    @Override
    public void getInfo() {
        for (Appender appender : appenders) {
            System.out.println(appender);
        }
    }
}
