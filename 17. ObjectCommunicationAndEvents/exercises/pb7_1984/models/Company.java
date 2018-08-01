package pb7_1984.models;

import java.util.LinkedHashMap;

public class Company extends BaseSubject {
    private int turnover;
    private int revenue;

    public Company(String id, String name, int turnover, int revenue) {
        super(id, name);
        this.turnover = turnover;
        this.revenue = revenue;
    }


}
