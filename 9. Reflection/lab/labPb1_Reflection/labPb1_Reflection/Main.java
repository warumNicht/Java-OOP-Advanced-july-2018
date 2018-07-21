package labPb1_Reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class aClass=Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());

        Class[] interfaces=aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        try {
            Reflection ref = (Reflection) aClass.newInstance();
            System.out.println(ref);
        }catch (IllegalAccessException e){
            ;
        }




    }
}
