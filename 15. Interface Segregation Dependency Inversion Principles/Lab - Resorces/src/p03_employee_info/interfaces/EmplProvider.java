package p03_employee_info.interfaces;

import java.util.List;

public interface EmplProvider {

    List<?> getEmployeesByName();
    Iterable<?> getEmployeesBySalary();
}
