package pb10_to14_InfernoInfinityAnnotation.interfaces;

import pb10_to14_InfernoInfinityAnnotation.enums.Gem;

public interface Weapon {
    void addGem(Gem gem,int index);
    void removeGem(int index);
    String getName();

    double getLevel();
    int compareTo(Weapon o);
    void print();
}
