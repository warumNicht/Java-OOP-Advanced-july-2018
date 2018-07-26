package p04_rechargeWithAdapterB;

public class RobotAdapter extends Robot implements Rechargeable {


    public RobotAdapter(String id, int capacity) {
        super(id, capacity);
    }

    @Override
    public void recharge() {
        this.setCurrentPower(this.getCurrentPower()+this.getCapacity());
    }
}
