package pb1_WeekDays_2;

public enum Season {
    SPRING(34,"Sehr gut"),
    SUMMER(36,"Am besten"),
    AUTUMN(28,"Befriedigend");

    private int maxTemp;
    private String atm;

    Season(int maxTemp, String atm) {
        this.maxTemp = maxTemp;
        this.atm = atm;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}
