package p04_rechargeWithAdapterB;

public class RobotAdapter implements Rechargeable {
    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void recharge() {
        this.robot.setCurrentPower(this.robot.getCurrentPower()+this.robot.getCapacity());
    }
}
