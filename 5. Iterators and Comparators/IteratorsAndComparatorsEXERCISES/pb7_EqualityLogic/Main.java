package pb7_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());


        Set<Person> uniquesTree=new TreeSet<>();
        HashSet <Person> uniquesHash=new HashSet<>();

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split("\\s+");
            Person curPerson=new Person(tokens[0],Integer.parseInt(tokens[1]));

            uniquesTree.add(curPerson);
            uniquesHash.add(curPerson);

        }
        System.out.println(uniquesTree.size());
        System.out.println(uniquesHash.size());

    }
}
