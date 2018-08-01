package proj.loggers;

import proj.LogType;

public class ErrorLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if(type== LogType.ERROR){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
