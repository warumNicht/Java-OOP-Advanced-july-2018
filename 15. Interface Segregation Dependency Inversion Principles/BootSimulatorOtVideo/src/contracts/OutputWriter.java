package contracts;

public interface OutputWriter {
    void writeLine(String line);
    void writeLine(String format,Object... arguments);
}
