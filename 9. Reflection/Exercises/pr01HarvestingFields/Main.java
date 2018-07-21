package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Field> fields=new ArrayList<>();
		String com=scanner.nextLine();

		Class cl=RichSoilLand.class;

		while ("HARVEST".equals(com)==false){
			switch (com){
				case "private":{
					Arrays.stream(cl.getDeclaredFields())
							.filter(x->Modifier.isPrivate(x.getModifiers()))
							.forEach(y->{
								System.out.println(String.format("private %s %s",
										y.getType().getSimpleName(),y.getName()));
							});
				}break;
				case "public":{
					Arrays.stream(cl.getDeclaredFields())
							.filter(x->Modifier.isPublic(x.getModifiers()))
							.forEach(y->{
								System.out.println(String.format("%s %s %s",
										Modifier.toString(y.getModifiers()),y.getType().getSimpleName(),y.getName()));
							});
				}break;
				case "protected":{
					Arrays.stream(cl.getDeclaredFields())
							.filter(x->Modifier.isProtected(x.getModifiers()))
							.forEach(y->{
								System.out.println(String.format("%s %s %s",
										Modifier.toString(y.getModifiers()),y.getType().getSimpleName(),y.getName()));
							});
				}break;
				case "all":{
					Arrays.stream(cl.getDeclaredFields())
							.forEach(y->{
								System.out.println(String.format("%s %s %s",
										Modifier.toString(y.getModifiers()),y.getType().getSimpleName(),y.getName()));
							});
				}break;
			}

			com=scanner.nextLine();
		}

	}
}
