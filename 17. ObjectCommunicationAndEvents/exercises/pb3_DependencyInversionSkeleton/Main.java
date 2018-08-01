package pb3_DependencyInversionSkeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrimitiveCalculator calculator=new PrimitiveCalculator();

        while (true){
            String input=reader.readLine();
            if("End".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");

            if("mode".equals(tokens[0])){
                calculator.changeStrategy(tokens[1].charAt(0));
            }else {
                int firstOp=Integer.parseInt(tokens[0]);
                int secOp=Integer.parseInt(tokens[1]);
                System.out.println(calculator.performCalculation(firstOp,secOp));
            }

        }

    }
}
