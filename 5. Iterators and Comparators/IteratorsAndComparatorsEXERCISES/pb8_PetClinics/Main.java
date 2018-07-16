package pb8_PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ClinicManager manager=new ClinicManager();

        int n=Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){
            String input=reader.readLine();
            String[] tokens=input.split("\\s+");

            switch (tokens[0]){
                case "Create":{
                    if("Pet".equals(tokens[1])){
                        manager.createPet(tokens[2],Integer.parseInt(tokens[3]),tokens[4]);
                    }else {
                        try {
                            manager.createClinic(tokens[2],Integer.parseInt(tokens[3]));
                        }catch (IllegalArgumentException error){
                            System.out.println(error.getMessage());
                        }
                    }
                }break;
                case "Add":{
                    System.out.println(manager.add(tokens[1],tokens[2]));
                }break;
                case "Release":{
                    System.out.println(manager.release(tokens[1]));
                }break;
                case "HasEmptyRooms":{
                    System.out.println(manager.hasEmpty(tokens[1]));
                }break;
                case "Print":{
                    if(tokens.length==2){
                        manager.print(tokens[1]);
                    }else {
                        manager.print(tokens[1],Integer.parseInt(tokens[2]));
                    }
                }break;

            }

        }
    }
}
