package pb10_InfernoInfinity60ot100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        WeaponManager manager=new WeaponManager();

        while ("END".equals(input)==false){

            String[] tokens=input.split(";");

            switch (tokens[0]){
                case "Create":{
                    manager.createWeapon(tokens[2],Weapon.valueOf(tokens[1].toUpperCase()));
                }break;
                case "Add":{
                    Gem gem=Gem.valueOf(tokens[3].toUpperCase());
                    manager.addGem(tokens[1],Integer.parseInt(tokens[2]),gem);
                }break;
                case "Remove":{
                    manager.removeGem(tokens[1],Integer.parseInt(tokens[2]));
                }break;
                case "Print":{
                    manager.print(tokens[1]);
                }break;

            }

            input=reader.readLine();
        }


    }
}
