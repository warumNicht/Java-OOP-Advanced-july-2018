package proj;

import proj.interfaces.Attacker;

public interface AttackGroup {
    void addMember(Attacker attacker);
    void groupTarget(Target target);
    void groupAttack();
}
