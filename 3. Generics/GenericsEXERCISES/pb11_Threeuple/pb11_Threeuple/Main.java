package pb11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]input1=reader.readLine().split("\\s+");
        String name=input1[0]+" "+input1[1];
        Threeuple<String,String,String> tup1=new Threeuple<>(name,input1[2],input1[3]);

        input1=reader.readLine().split("\\s+");
        boolean isDrunk=false;
        if(input1[2].equals("drunk")){
            isDrunk=true;
        }
        Threeuple<String,String,Boolean> tup2=new Threeuple<>(input1[0],input1[1],isDrunk);

        input1=reader.readLine().split("\\s+");
        Threeuple<String,Double,String> tup3=new Threeuple<>(input1[0],Double.parseDouble(input1[1]),input1[2]);


        System.out.println(tup1.toString());
        System.out.println(tup2.toString());
        System.out.println(tup3.toString());

    }
}
