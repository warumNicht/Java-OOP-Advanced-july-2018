package cresla.io;

import cresla.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader=new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine()  {
        return null;
    }
}
