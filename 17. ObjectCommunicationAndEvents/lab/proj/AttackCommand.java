package proj;

import proj.interfaces.Attacker;
import proj.interfaces.Command;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
