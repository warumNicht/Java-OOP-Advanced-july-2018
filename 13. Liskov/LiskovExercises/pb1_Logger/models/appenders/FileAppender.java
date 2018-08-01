package pb1_Logger.models.appenders;

import pb1_Logger.interfaces.File;
import pb1_Logger.interfaces.Layout;
import pb1_Logger.models.LogFile;
import pb1_Logger.models.Message;

public class FileAppender extends BaseAppender{
    private File file;

    public FileAppender(Layout format) {
        super(format);
        this.file = new LogFile();
    }

    @Override
    public void appendMessage(Message message) {
        if(message.getReportLevel().ordinal()>=this.getReportLevel().ordinal()){
            String result=this.getLayoutFormat().getFormat(message);
            this.file.write(result);
            this.increaseMessagesAppendedCount();
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(String.format(", File size: %d",this.file.getSize()));
        return res.toString();
    }
}
