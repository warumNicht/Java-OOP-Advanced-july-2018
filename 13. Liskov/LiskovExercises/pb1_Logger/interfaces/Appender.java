package pb1_Logger.interfaces;

import pb1_Logger.enums.ReportLevel;
import pb1_Logger.models.Message;

public interface Appender {
    void appendMessage(Message message);
    void setReportLevel(String reportLevel);
}
