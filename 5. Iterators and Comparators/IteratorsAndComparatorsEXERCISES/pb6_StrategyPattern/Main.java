package pb6_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        Set<Person> sortedByName=new TreeSet<>(new ComparatorByName());
        Set<Person> sortedByAge=new TreeSet<>(new ComparatorByAge());

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split("\\s+");
            Person curPerson=new Person(tokens[0],Integer.parseInt(tokens[1]));

            sortedByName.add(curPerson);
            sortedByAge.add(curPerson);
        }

        sortedByName.forEach(System.out::println);
        for (Person person : sortedByAge) {
            System.out.println(person.toString());
        }

    }
}
