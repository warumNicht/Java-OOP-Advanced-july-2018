package p03_employee_info.interfaces;

import p03_employee_info.Employee;

import java.util.List;

public interface DataBase {
    List<Employee> readEmployees();
}
