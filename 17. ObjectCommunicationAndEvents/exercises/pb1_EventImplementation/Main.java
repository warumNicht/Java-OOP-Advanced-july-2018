package pb1_EventImplementation;

import pb1_EventImplementation.events.Event;
import pb1_EventImplementation.events.NameChange;
import pb1_EventImplementation.interfaces.NameChangeListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        NameChangeListener handler=new Handler();
        Dispatcher dispatcher=new Dispatcher();
        dispatcher.addNameChangeListener(handler);

        while (true){
            String input=reader.readLine();
            if("End".equals(input)){
                break;
            }
            Event event=new NameChange(input);

            dispatcher.fireNameChangeEvent(event);


        }


    }
}
