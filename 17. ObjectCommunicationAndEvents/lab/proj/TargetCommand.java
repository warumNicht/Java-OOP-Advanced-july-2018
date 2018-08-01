package proj;

import proj.interfaces.Attacker;
import proj.interfaces.Command;

public class TargetCommand implements Command {
    private  Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }
    private void setTarget(Attacker attacker, Target target){
        attacker.setTarget(target);
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
