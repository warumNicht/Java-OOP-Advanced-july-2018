package pb4_WorkForce.models.employees;

public class StandartEmployee extends BaseEmployee {
    public static final int STANDART_HOURS=40;

    public StandartEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(STANDART_HOURS);
    }
}
