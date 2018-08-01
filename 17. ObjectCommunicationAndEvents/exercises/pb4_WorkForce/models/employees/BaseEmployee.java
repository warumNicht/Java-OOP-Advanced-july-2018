package pb4_WorkForce.models.employees;

import pb4_WorkForce.interfaces.Employee;

public abstract class BaseEmployee implements Employee {
    private String name;
    private int workHoursPerWeek;

    protected BaseEmployee(String name) {
        this.name = name;
    }

    protected void setWorkHoursPerWeek(int workHoursPerWeek) {
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
