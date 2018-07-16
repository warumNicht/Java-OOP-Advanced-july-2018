package pb9_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        LinkedList<Integer> list=new LinkedList<>();

        for(int i=0; i<n; i++){

            String[]tokens=reader.readLine().split("\\s+");
            if("Add".equals(tokens[0])){
                list.add(Integer.parseInt(tokens[1]));
            }else {
                list.remove(Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(list.getSize());

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

    }
}
