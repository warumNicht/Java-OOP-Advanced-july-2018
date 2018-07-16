package pb3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String comm=reader.readLine();

        Stack<Integer> stack=new Stack();

        while ("END".equals(comm)==false){

            if(comm.equals("Pop")){
                try {
                    stack.pop();
                }catch (IllegalArgumentException er){
                    System.out.println(er.getMessage());
                }

            }else {
                String[]tokens=comm.split("\\s+|,\\s+");
                for(int i=1; i<tokens.length; i++){
                    stack.push(Integer.parseInt(tokens[i]));
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
