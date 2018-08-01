package pb4_WorkForce;

import pb4_WorkForce.listener.EventListener;
import pb4_WorkForce.listener.JobEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EventListener listener=new JobEventListener();
        JobManager manager=new JobManager(listener);


        while (true){
            String input=reader.readLine();
            if("End".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");

            switch (tokens[0]){
                case "StandartEmployee":{
                    manager.createStandartEmployee(tokens[1]);
                }break;
                case "PartTimeEmployee":{
                    manager.createPartEmployee(tokens[1]);
                }break;
                case "Job":{
                    manager.createJob(tokens[1],Integer.parseInt(tokens[2]),tokens[3]);
                }break;
                case "Pass":{
                    manager.passWeek();
                }break;
                case "Status":{
                    manager.status();
                }break;
            }

        }

    }
}
