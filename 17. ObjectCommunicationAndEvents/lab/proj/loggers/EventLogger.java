package proj.loggers;

import proj.LogType;

public class EventLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if(type== LogType.EVENT){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
