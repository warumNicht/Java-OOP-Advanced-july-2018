package pb9_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]  tokens=reader.readLine().split("\\s+");

        Light[] lights=new Light[tokens.length];

        for(int i=0; i<tokens.length; i++){
            lights[i]=Light.valueOf(tokens[i]);
        }
        int n=Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){
            for(int j=0; j<tokens.length; j++){

                lights[j]=lights[j].update(lights[j]);
                System.out.print(lights[j].name()+" ");
            }
            System.out.println();
        }

    }
}
