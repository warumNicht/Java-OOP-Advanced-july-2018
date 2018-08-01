package proj;

import proj.interfaces.Attacker;
import proj.interfaces.Command;
import proj.interfaces.Executor;
import proj.loggers.CombatLogger;
import proj.loggers.ErrorLogger;
import proj.loggers.EventLogger;
import proj.loggers.Logger;

public class Main {
    public static void main(String[] args) {
        Logger combatLog=new CombatLogger();
        Logger errorLog=new ErrorLogger();
        Logger eventLog=new EventLogger();

        errorLog.setSuccessor(eventLog);

        combatLog.setSuccessor(eventLog);

        combatLog.handle(LogType.ATTACK,"some attack");
        combatLog.handle(LogType.ERROR,"some error");
        combatLog.handle(LogType.EVENT,"some event");


        eventLog.handle(LogType.EVENT,"some event");
        eventLog.handle(LogType.TARGET,"some attack");

        AbstractHero warrior=new Warrior("Warrior",10, combatLog);
        AbstractHero  warrior2=new Warrior("Warrior2",10, combatLog);
        AbstractHero  warrior3=new Warrior("Warrior3",7, combatLog);

        ObservableTarget dragon=  new Dragon("Dragon",15,25,combatLog);

        dragon.register(warrior);
        dragon.register(warrior2);
        dragon.register(warrior3);


        Executor executor=new CommandExecutor();

        Command target= new TargetCommand(warrior,dragon);
        Command attack=new AttackCommand(warrior);

        AttackGroup group=new Group();
        group.addMember(warrior);
        group.addMember(warrior2);

        Command groupTarget=new GroupTargetCommand(group,dragon);
        Command groupAttack=new GroupAttackCommand(group);

        groupTarget.execute();
        groupAttack.execute();


    }
}
