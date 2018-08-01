package proj.interfaces;

import proj.LogType;

public interface Handler {
    void handle(LogType type, String message);
    void setSuccessor(Handler handler);

}
