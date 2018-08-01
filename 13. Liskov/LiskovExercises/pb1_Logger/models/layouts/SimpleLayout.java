package pb1_Logger.models.layouts;

import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.Message;

public class SimpleLayout implements Layout {
    public SimpleLayout() {
    }

    @Override
    public String getFormat(Message message) {
        return String.format("%s - %s - %s",message.getDate(),
                message.getReportLevel().name(),message.getContent());
    }
}
