package pb6_MirrorImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]arguments=reader.readLine().split("\\s+");

        Wizard wizard=new WizardImpl(arguments[0],Integer.parseInt(arguments[1]));

        while (true){
            String input=reader.readLine();
            if("END".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");
            int index=Integer.parseInt(tokens[0]);
            String command=tokens[1];
            if("FIREBALL".equals(command)){
                wizard.castFireball(index);
            }else {
                wizard.castReflection(index);
            }

        }

    }
}
