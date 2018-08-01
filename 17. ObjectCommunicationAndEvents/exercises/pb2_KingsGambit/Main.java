package pb2_KingsGambit;

import pb2_KingsGambit.interfaces.KingMediator;
import pb2_KingsGambit.models.Footman;
import pb2_KingsGambit.models.Guard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kingname=reader.readLine();
        KingMediator mediator=new King(kingname);

        String[] guards=reader.readLine().split("\\s+");
        for (String guard : guards) {
            mediator.addGuard(new Guard(guard));
        }

        String[] footmans=reader.readLine().split("\\s+");
        for (String foot : footmans) {
            mediator.addGFootman(new Footman(foot));
        }

        while (true){
            String input=reader.readLine();
            if("End".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");

            if("Kill".equals(tokens[0])){
                mediator.respondToAttack(tokens[1]);
            }else {
                mediator.attack();
            }

        }
    }
}
