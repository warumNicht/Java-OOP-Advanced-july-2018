package P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp=new Employee("Ivan");
        List<String> docs=new ArrayList<>();
        docs.add("Vertrag");
        docs.add("Vorlage");
        docs.add("Bestatigung");

        Manager man=new Manager("6ef",docs);

        List<Employee> eployees=new ArrayList<>();
        eployees.add(emp);
        eployees.add(man);

        DetailsPrinter printer=new DetailsPrinter(eployees);

        printer.printEmployees();

    }
}
