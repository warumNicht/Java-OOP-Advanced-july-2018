package pb2_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance lowerImportance;
    private List<Message> messages;

    public Logger(Importance lowerImportance) {
        this.lowerImportance = lowerImportance;
        this.messages=new ArrayList<>();
    }

    public void log(Message message){
        if(message.getLevel().compareTo(this.lowerImportance)>=0){
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }


}
