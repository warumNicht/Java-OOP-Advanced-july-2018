package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    public BossFight(String[] participants) {
    }

    @Override
    public String executeAction(List<Targetable> participants) {
        if(participants.size()<1){
            return "There should be at least 1 participant for boss fight!";
        }
        if("Boss".equals(participants.get(0).getClass().getSimpleName())==false){
            return "Invalid boss.";
        }
        Targetable boss=participants.get(0);
        List<Targetable> targets=participants.stream().skip(1).collect(Collectors.toList());

        StringBuilder res=new StringBuilder();

        while (true){
            Targetable attakingHero=targets.remove(0);
            attakingHero.attack(boss);
            if(boss.isAlive()==false){
                attakingHero.receiveReward(boss.getGold());
                //attakingHero.levelUp();
               boss.giveReward(attakingHero);

                for (Targetable target : targets) {
                    target.levelUp();
                    boss.giveReward(target);
                }
                targets.add(attakingHero);
                res.append(("Boss has been slain by:"))
                        .append(System.lineSeparator());

                targets.stream()
                        .sorted((x,y)->x.getName().compareTo(y.getName()))
                        .forEach(x->{
                            res.append(x.toString()).append(System.lineSeparator());
                        });

                break;
            }
            boss.attack(attakingHero);

            if(attakingHero.isAlive()){
                targets.add(attakingHero);
            }
            if(targets.isEmpty()){
                res.append("Boss has slain them all!");
                break;
            }

        }

        return res.toString().trim();
    }
}
