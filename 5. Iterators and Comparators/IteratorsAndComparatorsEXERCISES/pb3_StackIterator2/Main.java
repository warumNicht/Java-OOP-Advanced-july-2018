package pb3_StackIterator2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyStack<Integer> stack=new MyStack<>();

        String comm=reader.readLine();

        while ("END".equals(comm)==false){

            if(comm.equals("Pop")){
                try {
                    stack.pop();
                }catch (NoSuchElementException er){
                    System.out.println("No elements");
                }

            }else {
                String[]tokens= Arrays.stream(comm.split("\\s+"))
                        .map(e->e.replace(",",""))
                        .toArray(String[]::new);
                int[] nums= Arrays.stream(tokens).skip(1)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for(int i=0; i<nums.length; i++){
                    stack.push(nums[i]);
                }
            }
            comm=reader.readLine();
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
