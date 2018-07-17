package pb10_to14_InfernoInfinityAnnotation;

import pb10_to14_InfernoInfinityAnnotation.enums.Gem;
import pb10_to14_InfernoInfinityAnnotation.enums.WeaponType;
import pb10_to14_InfernoInfinityAnnotation.interfaces.Weapon;
import pb10_to14_InfernoInfinityAnnotation.models.WeaponImpl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Weapon> weapons=new HashMap<>();

        while (true){
            String input=reader.readLine();
            if("END".equals(input)){
                break;
            }

            String[] tokens=input.split(";");

            switch (tokens[0]){
                case "Create":{
                    WeaponType weponType=WeaponType.valueOf(tokens[1]);
                    Weapon wepon=new WeaponImpl(tokens[2],weponType);
                    weapons.put(tokens[2],wepon );
                }break;
                case "Add":{
                    Gem gem=Gem.valueOf(tokens[3].toUpperCase());
                    Weapon curWeoapon=weapons.get(tokens[1]);
                    curWeoapon.addGem(gem,Integer.parseInt(tokens[2]));

                }break;
                case "Remove":{
                    Weapon curWeoapon=weapons.get(tokens[1]);
                    curWeoapon.removeGem(Integer.parseInt(tokens[2]));

                }break;
                case "Print":{
                    Weapon curWeoapon=weapons.get(tokens[1]);
                    System.out.println(curWeoapon.toString());
                }break;
                case "Compare":{
                    Weapon weapon1=weapons.get(tokens[1]);
                    Weapon weapon2=weapons.get(tokens[2]);
                    if(weapon1.compareTo(weapon2)>=0){
                        weapon1.print();
                    }else {
                        weapon2.print();
                    }

                }break;
                case "Author":{
                    CustomAnnotation ca=WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Author: "+ ca.author());
                }break;
                case "Revision":{
                    CustomAnnotation ca=WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Revision: "+ ca.revision());
                }break;
                case "Description":{
                    CustomAnnotation ca=WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Class description: "+ ca.description());
                }break;
                case "Reviewers":{
                    CustomAnnotation ca=WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.println("Reviewers: "+ String.join(", ",ca.reviewers()));
                }break;

            }

        }



    }
}
