package p03_employee_info;

import p03_employee_info.interfaces.EmplProvider;
import p03_employee_info.interfaces.Formatter;

public class Main {

    public static void main(String[] args) {
        EmplProvider employeeProvider = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient client=new ConsoleClient(formatter,employeeProvider);

        String output = client.getResultByName();
        System.out.print(output);
        System.out.println(client.getResultBySalary());
    }
}
