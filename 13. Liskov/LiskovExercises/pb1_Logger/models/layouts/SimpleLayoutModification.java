package pb1_Logger.models.layouts;

import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.Message;

public class SimpleLayoutModification implements Layout {
    public SimpleLayoutModification() {
    }

    @Override
    public String getFormat(Message message) {
        return String.format("%s <-> %s <-> %s",message.getDate(),
                message.getReportLevel().name(),message.getContent());
    }
}
