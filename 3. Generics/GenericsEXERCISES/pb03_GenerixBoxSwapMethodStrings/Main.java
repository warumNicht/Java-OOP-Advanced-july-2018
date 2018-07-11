package pb01_02_GenerixBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        List<Box> boxes=new ArrayList<>();

        for(int i=0; i<n; i++){
            boxes.add(new Box(reader.readLine()));
        }
        int[] indexes= Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(x->Integer.parseInt(x))
                .toArray();

        Box.swapGeneric(boxes,indexes[0],indexes[1]);

        for (Box box : boxes) {
            System.out.println(box.toString());
        }

    }
}
