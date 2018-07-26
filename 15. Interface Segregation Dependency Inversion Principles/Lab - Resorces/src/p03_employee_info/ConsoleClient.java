package p03_employee_info;

import p03_employee_info.interfaces.EmplProvider;
import p03_employee_info.interfaces.Formatter;

public class ConsoleClient {
    private Formatter formatter;
    private EmplProvider emplProvider;

    public ConsoleClient(Formatter formatter, EmplProvider emplProvider) {
        this.formatter = formatter;
        this.emplProvider = emplProvider;
    }

    public String getResultByName(){
        return this.formatter.format(this.emplProvider.getEmployeesByName());
    }

    public String getResultBySalary(){
        return this.formatter.format(this.emplProvider.getEmployeesBySalary());
    }
}
