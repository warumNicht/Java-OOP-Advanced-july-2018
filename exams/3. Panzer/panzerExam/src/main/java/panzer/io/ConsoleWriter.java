package panzer.io;


import panzer.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {


    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}
