package pb1_Logger.models.layouts;

import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.Message;

public class XmlLayout implements Layout {
    public XmlLayout() {
    }

    @Override
    public String getFormat(Message message) {
        StringBuilder format=new StringBuilder();
        format.append("<log>")
                .append(System.lineSeparator())
                .append("\t<date>%s</date>")
                .append(System.lineSeparator())
                .append("\t<level>%s</level>")
                .append(System.lineSeparator())
                .append("\t<message>%s</message>")
                .append(System.lineSeparator())
                .append("</log>");
        return String.format(format.toString(),
                message.getDate(), message.getReportLevel().name(),
                message.getContent());
    }
}
