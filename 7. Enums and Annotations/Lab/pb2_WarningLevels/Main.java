package pb2_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String level=reader.readLine();

        Logger logger=new Logger(Importance.valueOf(level));

        String input=reader.readLine();

        while ("END".equals(input)==false){

            String[] tokens=input.split(": ");

            logger.log(new Message(Importance.valueOf(tokens[0]),tokens[1]));

            input=reader.readLine();
        }
        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
