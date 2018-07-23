package pb6_Twitter.models;

import pb6_Twitter.interfaces.Writer;

public class ConsoleWriterImpl implements Writer {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
