package genericsExercises.pb02_GenerixBoxofInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        List<Box<Integer>> boxes=new ArrayList<>();

        for(int i=0; i<n; i++){
            boxes.add(new Box(Integer.parseInt(reader.readLine())));
        }

        for (Box box : boxes) {
            System.out.println(box.toString());
        }

    }
}
