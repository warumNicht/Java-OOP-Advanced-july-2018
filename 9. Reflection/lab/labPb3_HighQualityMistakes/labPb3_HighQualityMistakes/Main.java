package labPb3_HighQualityMistakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class aClass= Reflection.class;

        List<Field> fields=Arrays.asList(aClass.getDeclaredFields());

        fields.sort(new Comparator<Field>() {
            @Override
            public int compare(Field o1, Field o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Field field : fields) {
            if(!Modifier.isPrivate(field.getModifiers())){
                System.out.println(field.getName()+" must be private!");
            }
        }

        List<Method> methods=Arrays.asList(aClass.getDeclaredMethods());

        methods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Method method : methods) {
            if(method.getName().startsWith("get")){
                if(method.getParameterTypes().length==0){
                    if(!Modifier.isPublic(method.getModifiers())){
                        System.out.println(method.getName()+" have to be public!");
                    }
                }
            }
        }
        for (Method method : methods) {
            if(method.getName().startsWith("set")){
                if(method.getParameterTypes().length==1){
                    if(!Modifier.isPrivate(method.getModifiers())){
                        System.out.println(method.getName()+" have to be private!");
                    }
                }
            }
        }





    }
}
