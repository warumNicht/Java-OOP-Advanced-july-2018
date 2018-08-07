package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String classPath="";
        Targetable targetable=null;
        switch (className) {
            case "Warrior":
                targetable = new Warrior(name);
                System.out.println(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            case "Wizard":
                targetable = new Wizard(name);
                System.out.println(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            case "Necromancer":
                targetable = new Necromancer(name);
                System.out.println(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            case "Boss":
                targetable = new Boss(name);
                System.out.println(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            default:
                System.out.println("Participant class does not exist.");
        }


        return targetable;
    }
}
