package pb1_Logger.models;

import pb1_Logger.enums.ReportLevel;

public class Message {
    private ReportLevel reportLevel;
    private String date;
    private String content;

    public Message(ReportLevel reportLevel, String date, String content) {
        this.reportLevel = reportLevel;
        this.date = date;
        this.content = content;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
