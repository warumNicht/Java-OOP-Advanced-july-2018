package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

		Scanner scanner = new Scanner(System.in);
		Class cl=BlackBoxInt.class;
		Constructor emptyConstr=cl.getDeclaredConstructor(null);
		emptyConstr.setAccessible(true);
		BlackBoxInt instance=(BlackBoxInt) emptyConstr.newInstance();

		String input=scanner.nextLine();

		while ("END".equals(input)==false){
			String[] tokens=input.split("_");
			String methodType=tokens[0];
			int value=Integer.parseInt(tokens[1]);
			Method method=null;


			method=cl.getDeclaredMethod(methodType,int.class);

			method.setAccessible(true);
			method.invoke(instance,value);

			Field field=cl.getDeclaredField("innerValue");
			field.setAccessible(true);
			System.out.println(field.get(instance));

			input=scanner.nextLine();
		}
	}
}
