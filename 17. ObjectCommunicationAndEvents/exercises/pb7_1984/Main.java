package pb7_1984;

import pb7_1984.interfaces.Subject;
import pb7_1984.models.Company;
import pb7_1984.models.Employee;
import pb7_1984.models.Institution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Subject> subjects=new HashMap<>();
        List<Institution> institutions=new ArrayList<>();

        int[] nums= Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(x->Integer.parseInt(x))
                .toArray();

        String[] tokens=null;

        for(int i=0; i<nums[0]; i++){
            Subject subject=null;
            tokens=reader.readLine().split("\\s+");
            if("Employee".equals(tokens[0])){
                subject=new Employee(tokens[1],tokens[2],Integer.parseInt(tokens[3]));
            }else {
                subject=new Company(tokens[1],tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
            }
            subjects.put(tokens[1],subject);
        }

        for(int i=0; i<nums[1]; i++){
            tokens=reader.readLine().split("\\s+");
            String[] sub= Arrays.copyOfRange(tokens,3,tokens.length);
            List<String> subTypes=Arrays.asList(sub);
            Institution institution=new Institution(tokens[1],tokens[2],subTypes);
            institutions.add(institution);
        }

        for(int i=0; i<nums[2]; i++){
            tokens=reader.readLine().split("\\s+");
            Subject subject=subjects.get(tokens[0]);
            String field=tokens[1];
            if("name".equals(field)){
                subject.update(institutions,field,tokens[2]);
            }else {
                try {
                    int newValue=Integer.parseInt(tokens[2]);
                    subject.update(institutions,field,newValue);
                }catch (Exception e){

                }
            }
        }

        for (Institution institution : institutions) {
            System.out.println(institution);
        }

    }
}
