package pb1_Logger.models.appenders;

import pb1_Logger.enums.ReportLevel;
import pb1_Logger.interfaces.Appender;
import pb1_Logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private ReportLevel reportLevel;
    private Layout layoutFormat;
    private int messagesAppendedCount;

    public BaseAppender(Layout format) {
        this.reportLevel=ReportLevel.INFO;
        this.layoutFormat = format;
        this.messagesAppendedCount=0;
    }


    protected ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected Layout getLayoutFormat() {
        return layoutFormat;
    }

    protected void increaseMessagesAppendedCount() {
        this.messagesAppendedCount++;
    }

    protected int getMessagesAppendedCount() {
        return messagesAppendedCount;
    }
    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layoutFormat.getClass().getSimpleName(),
                this.reportLevel.name(),this.messagesAppendedCount);
    }
    @Override
    public void setReportLevel(String reportLevel) {
        this.reportLevel=ReportLevel.valueOf(reportLevel.toUpperCase());
    }
}
