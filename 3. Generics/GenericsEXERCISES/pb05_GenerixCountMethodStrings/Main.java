package pb05_GenerixCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        List<String> boxes=new ArrayList<>();

        for(int i=0; i<n; i++){
            boxes.add(reader.readLine());
        }

        String element=reader.readLine();

        System.out.println(Box.countGreaterGeneric(boxes,element));


    }
}
