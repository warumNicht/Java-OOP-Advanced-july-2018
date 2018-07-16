package pb5_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people=new ArrayList<>();
        String input=reader.readLine();

        while ("END".equals(input)==false){
            String[] tokens=input.split("\\s+");
            Person current=new Person(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            people.add(current);

            input=reader.readLine();
        }

        int n=Integer.parseInt(reader.readLine());

        Person comparedPerson=people.get(n-1);

        int countEqual=0;

        for(int i=0; i<people.size(); i++){
            if(i!=n-1){
                if(comparedPerson.compareTo(people.get(i))==0){
                    countEqual++;
                }
            }
        }
        if(countEqual==0){
            System.out.println("No matches");
        }else {
            System.out.println(String.format("%d %d %d",
                    countEqual+1, people.size()-1-countEqual,people.size()));
        }


    }
}
