package app.core;

import app.contracts.ActionFactory;
import app.contracts.Battlefield;
import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.contracts.Action;
import app.io.ConsoleWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<String> executedActions;
    private ConsoleWriter writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(ConsoleWriter writer, TargetableFactory targetableFactory, ActionFactory actionFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new LinkedHashMap<>();
        this.writer = writer;
        this.targetableFactory=targetableFactory;
        this.actionFactory=actionFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames){
                if (this.participants.containsKey(name)){
                    actionParticipants.add(this.participants.get(name));
                } else {
                    System.out.println(String.format("%s is not on the battlefield. %s failed.", name, actionName));
                    return;
                }
            }
            Action action = this.actionFactory.create(actionName, participantNames);

            System.out.println(action.executeAction(actionParticipants));
            this.checkForDeadParticipants();
            this.executedActions.add(actionName);
        } catch (Exception e) {
            System.out.println("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)){
            System.out.println("Participant with that name already exists.");
            return;
        }

        Targetable targetable= null;
        try {
            targetable = this.targetableFactory.create( name, className);
            this.participants.put(targetable.getName(), targetable);

        } catch (ClassNotFoundException |IllegalAccessException | InstantiationException |
                NoSuchMethodException |InvocationTargetException  e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {

    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1) {
            System.out.println("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            System.out.println(this.participants.get(name).toString());
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1) {
            System.out.println("There are no actions on the battlefield.");
            return;
        }

        for (String executedAction : executedActions) {
            System.out.println(executedAction);
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new LinkedHashMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()){
                System.out.println(String.format("%s has been removed from the battlefield.", name));
            }else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
