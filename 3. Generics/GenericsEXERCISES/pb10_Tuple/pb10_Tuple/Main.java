package pb10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]input1=reader.readLine().split("\\s+");
        String names=input1[0]+" "+input1[1];

        Tuple<String,String> tup1=new Tuple<>(names,input1[2]);

        input1=reader.readLine().split("\\s+");

        Tuple<String,String> tup2=new Tuple<>(input1[0],input1[1]);

        input1=reader.readLine().split("\\s+");

        Tuple<Integer,Double> tup3=new Tuple<>(Integer.parseInt(input1[0]),Double.parseDouble(input1[1]));


        System.out.println(tup1.toString());
        System.out.println(tup2.toString());
        System.out.println(tup3.toString());

    }
}
