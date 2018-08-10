package hell;

import hell.entities.models.HeroManager;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader=new ConsoleReader();
        OutputWriter writer=new ConsoleWriter();
        HeroManager manager=new HeroManager();

        String input=reader.readLine();

        while (true){
            String[]tokens=input.split("\\s+");
            String res=null;

            switch (tokens[0]){
                case "Hero":{
                    res=manager.addHero(tokens[1],tokens[2]);
                }break;
                case "Item":{
                    int strengthBonus=Integer.parseInt(tokens[3]);
                    int agilityBonus=Integer.parseInt(tokens[4]);
                    int intelligenceBonus=Integer.parseInt(tokens[5]);
                    int hitPointsBonus=Integer.parseInt(tokens[6]);
                    int damageBonus=Integer.parseInt(tokens[7]);
                    res=manager.addItem(tokens[1],tokens[2],strengthBonus,agilityBonus,intelligenceBonus,hitPointsBonus,damageBonus);
                }break;
                case "Recipe":{
                    int strengthBonus=Integer.parseInt(tokens[3]);
                    int agilityBonus=Integer.parseInt(tokens[4]);
                    int intelligenceBonus=Integer.parseInt(tokens[5]);
                    int hitPointsBonus=Integer.parseInt(tokens[6]);
                    int damageBonus=Integer.parseInt(tokens[7]);
                    List<String> items=new ArrayList<>();
                    for(int i=8; i<tokens.length; i++){
                        items.add(tokens[i]);
                    }
                    res=manager.addRecipe(tokens[1],tokens[2],strengthBonus,agilityBonus,intelligenceBonus,hitPointsBonus,damageBonus, items);
                }break;
                case "Inspect":{
                    res=manager.inspect(tokens[1]);
                }break;
                case "Quit":{
                    res=manager.quit();
                    writer.writeLine(res);
                    return;
                }
            }
            if(res!=null)
            writer.writeLine(res);

            input=reader.readLine();
        }
    }
}