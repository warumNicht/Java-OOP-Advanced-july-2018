package pb10_to14_InfernoInfinityAnnotation.enums;

public enum WeaponType {
    AXE(5,10,4),
    SWORD(4,6,3),
    KNIFE(3,4,2);

    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;

    private WeaponType(int minDamage, int maxDamage, int numberOfSockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfSockets = numberOfSockets;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getNumberOfSockets() {
        return numberOfSockets;
    }
}
