package P02_FileStream;

public class File implements Streamable{

    private String name;
    private int length;
    private int bytesSent;

    public File(String name, int length, int bytesSent) {
        this.name = name;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return length;
    }
    @Override
    public int getBytesSent() {
    return bytesSent;
    }
}
