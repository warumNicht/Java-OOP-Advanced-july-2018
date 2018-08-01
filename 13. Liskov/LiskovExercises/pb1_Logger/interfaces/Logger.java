package pb1_Logger.interfaces;

import pb1_Logger.models.Message;

public interface Logger {
    void logMessage(Message message);
    void getInfo();
}
