package pb1_Logger.interfaces;

import pb1_Logger.models.Message;

public interface Layout {
    String getFormat(Message message);
}
