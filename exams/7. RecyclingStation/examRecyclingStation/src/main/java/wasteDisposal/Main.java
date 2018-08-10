package wasteDisposal;

import wasteDisposal.annotations.Burning;
import wasteDisposal.annotations.Recyling;
import wasteDisposal.annotations.Storing;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.factory.WasteFactory;
import wasteDisposal.models.strategies.BurnableStrategy;
import wasteDisposal.models.strategies.RecyclableStrategy;
import wasteDisposal.models.strategies.StorableStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StrategyHolder strategyHolder=new DefaultStrategyHolder();

        Class anotBurnableClass=Burning.class;
        GarbageDisposalStrategy burn=new BurnableStrategy();
        Class anotRecycleClass=Recyling.class;
        GarbageDisposalStrategy recyc=new RecyclableStrategy();
        Class anotStroableClass=Storing.class;
        GarbageDisposalStrategy store=new StorableStrategy();

        strategyHolder.addStrategy(anotBurnableClass,burn);
        strategyHolder.addStrategy(anotRecycleClass,recyc);
        strategyHolder.addStrategy(anotStroableClass,store);

        GarbageProcessor garbageProcessor=new DefaultGarbageProcessor(strategyHolder);
        WasteFactory wasteFactory=new WasteFactory();

        RecyclingManager manager=new RecyclingManager(garbageProcessor, wasteFactory);



        String input=reader.readLine();

        while (true){
            String[]tokens=input.split("(\\s+)|(\\|)");
            String res=null;

            String command=tokens[0];
            String[] arguments= Arrays.stream(tokens).skip(1).toArray(String[]::new);

            switch (command){
                case "ProcessGarbage":{
                    try {
                        res=manager.processGarbage(arguments);
                    } catch (ClassNotFoundException | InvocationTargetException |
                            InstantiationException | IllegalAccessException e) {
                        System.out.println(e.getMessage());;
                    }
                }break;
                case "Status":{
                    res=manager.status();
                }break;
                case "ChangeManagementRequirement":{
                    res=manager.changeManagementRequirement(arguments);
                }break;
                case "TimeToRecycle":{
                    return;
                }

            }
            if(res!=null)
                System.out.println(res);

            input=reader.readLine();
        }
    }
}
