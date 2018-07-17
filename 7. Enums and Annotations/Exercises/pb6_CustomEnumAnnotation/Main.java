package pb6_CustomEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String packageName = Main.class.getCanonicalName();
        String input=reader.readLine();
        if(input.equals("Rank")==false){
            input="Suite";
        }


        try {
            Class<?> curClass=Class.forName((packageName.replace("Main", input)));

            if(curClass!=null){
                CustomAnnotation anot=curClass.getAnnotation(CustomAnnotation.class);

                System.out.println(String.format("Type = %s, Description = %s", anot.type(),anot.description()));
            }

        }catch (ClassNotFoundException e){
            ;
        }


    }
}
