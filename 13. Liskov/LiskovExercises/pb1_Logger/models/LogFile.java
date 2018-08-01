package pb1_Logger.models;

import pb1_Logger.interfaces.File;

public class LogFile implements File {
    private StringBuilder content;

    public LogFile() {
        this.content = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.content.append(message);
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }
    private int calculateSize(){
        int res=0;
        for(int i=0; i<this.content.length(); i++){
            if(Character.isAlphabetic(this.content.charAt(i))){
                res+=this.content.charAt(i);
            }
        }
        return res;
    }
}
