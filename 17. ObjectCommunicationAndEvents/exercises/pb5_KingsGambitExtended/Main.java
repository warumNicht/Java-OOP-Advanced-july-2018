package pb5_KingsGambitExtended;

import pb5_KingsGambitExtended.interfaces.KingMediator;
import pb5_KingsGambitExtended.models.Footman;
import pb5_KingsGambitExtended.models.Guard;
import pb5_KingsGambitExtended.models.KillDefenderEvent;

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
            mediator.addDefender(new Guard(guard));
        }

        String[] footmans=reader.readLine().split("\\s+");
        for (String foot : footmans) {
            mediator.addDefender(new Footman(foot));
        }

        while (true){
            String input=reader.readLine();
            if("End".equals(input)){
                break;
            }
            String[] tokens=input.split("\\s+");

            if("Kill".equals(tokens[0])){

                mediator.killAttacker(tokens[1]);
            }else {
                mediator.getAttacked();
            }

        }
    }
}
