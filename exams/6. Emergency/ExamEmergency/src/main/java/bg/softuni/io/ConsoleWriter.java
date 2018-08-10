package bg.softuni.io;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);

    }

}
