package softuni.models;

import softuni.models.entities.CoreManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoreManager manager=new CoreManager();

        String input=reader.readLine();
        while (true){
            String[]tokens=input.split("@");
            String res=null;


            switch (tokens[0]){
                case "CreateCore:":{
                    res= manager.addCore(tokens[1], Integer.parseInt(tokens[2]));
                }break;
                case "RemoveCore:":{
                    res= manager.removeCore(tokens[1]);
                }break;
                case "AttachFragment:":{
                    res= manager.attachFragment(tokens[1],tokens[2], Integer.parseInt(tokens[3]));
                }break;
                case "DetachFragment:":{
                    res= manager.dettachFragment();
                }break;
                case "SelectCore:":{
                    res= manager.selectCore(tokens[1]);
                }break;
                case "Status:":{
                    res= manager.status();
                }break;
                case "System Shutdown!":{
                    return;
                }
            }
            if(res!=null)
                System.out.println(res);

            input=reader.readLine();
        }
    }
}
