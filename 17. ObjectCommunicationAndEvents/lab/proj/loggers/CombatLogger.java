package proj.loggers;

import proj.LogType;

public class CombatLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if(type== LogType.ATTACK||type== LogType.MAGIC
                ||type== LogType.TARGET){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
