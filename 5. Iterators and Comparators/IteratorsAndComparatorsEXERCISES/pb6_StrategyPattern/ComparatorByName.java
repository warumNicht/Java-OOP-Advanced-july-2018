package pb6_StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getName().length()==o2.getName().length()){
            return Character.toLowerCase(o1.getName().charAt(0)) - Character.toLowerCase(o2.getName().charAt(0));
        }
        return o1.getName().length()-o2.getName().length();
    }
}
