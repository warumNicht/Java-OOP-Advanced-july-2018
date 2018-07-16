package pb1_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

         String input=reader.readLine();

         String[] tokens=input.split("\\s+");

         ListyIterator<String> list=new ListyIterator(tokens);

         input=reader.readLine();

         while ("END".equals(input)==false){

            switch (input){
                case "Move":{
                    System.out.println(list.move());
                }break;
                case "Print":{
                    try {
                        list.print();
                    }catch (IllegalArgumentException error){
                        System.out.println(error.getMessage());
                    }

                }break;
                case "HasNext":{
                    System.out.println(list.hasNext());

                }break;
            }

             input=reader.readLine();
         }
    }
}
