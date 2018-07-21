//package labPb2_GettersandSetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class aClass= Reflection.class;

        Method[] methods=aClass.getDeclaredMethods();
        List<Method> getters=new ArrayList<>();
        List<Method> setters=new ArrayList<>();

        for (Method method : methods) {
            if(method.getName().startsWith("get")){
                if(method.getParameterTypes().length==0){
                    getters.add(method);
                }
            }else if(method.getName().startsWith("set")){
                if(method.getParameterTypes().length==1){
                    setters.add(method);
                }
            }
        }

        getters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(m.getName()+" will return "+m.getReturnType()));


        setters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(m.getName()+" and will set field of "+m.getParameterTypes()[0]));



    }
}
