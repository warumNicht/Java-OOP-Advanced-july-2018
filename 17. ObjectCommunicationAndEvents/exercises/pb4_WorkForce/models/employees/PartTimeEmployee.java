package pb4_WorkForce.models.employees;

public class PartTimeEmployee extends BaseEmployee {
    public static final int PART_HOURS=20;
    public PartTimeEmployee(String name) {
        super(name);
        super.setWorkHoursPerWeek(PART_HOURS);
    }
}
