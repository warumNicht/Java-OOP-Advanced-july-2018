package pb4_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[]nums=  Arrays.stream(reader.readLine().split("\\s+|,\\s+"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        
        Lake<Integer> lake=new Lake(nums);
        List<String> res=new ArrayList<>();
        for (Integer integer : lake) {
            res.add(""+integer);
        }
        String end=reader.readLine();

        System.out.println(String.join(", ",res));

    }
}
