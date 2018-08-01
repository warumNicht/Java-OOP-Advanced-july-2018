package pb1_Logger.models.appenders;

import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.Message;

public class ConsoleAppender extends BaseAppender{
    public ConsoleAppender(Layout format) {
        super(format);
    }

    @Override
    public void appendMessage(Message message) {
        if(message.getReportLevel().ordinal()>=this.getReportLevel().ordinal()){
            String result=this.getLayoutFormat().getFormat(message);
            System.out.println(result);
            this.increaseMessagesAppendedCount();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
