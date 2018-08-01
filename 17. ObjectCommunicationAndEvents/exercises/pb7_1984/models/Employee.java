package pb7_1984.models;

public class Employee extends BaseSubject {
    private int income;

    public Employee(String id, String name, int income) {
        super(id, name);
        this.income = income;
    }
}
