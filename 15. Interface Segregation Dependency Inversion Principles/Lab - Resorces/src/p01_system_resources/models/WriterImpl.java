package p01_system_resources.models;

import p01_system_resources.interfaces.Writer;

public class WriterImpl implements Writer {
    @Override
    public void println(String string) {
        System.out.println(string);
    }
}
