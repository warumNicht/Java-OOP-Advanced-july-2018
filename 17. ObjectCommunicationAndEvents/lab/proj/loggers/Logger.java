package proj.loggers;

import proj.interfaces.Handler;
import proj.LogType;

public abstract class Logger implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message){
        if(this.successor!=null){
            this.successor.handle(type,message);
        }
    }

    public abstract void handle(LogType type, String message );
}
