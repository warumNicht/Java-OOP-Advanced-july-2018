package pb4_WorkForce;

import pb4_WorkForce.interfaces.Employee;
import pb4_WorkForce.listener.EventListener;
import pb4_WorkForce.models.Job;
import pb4_WorkForce.models.employees.PartTimeEmployee;
import pb4_WorkForce.models.employees.StandartEmployee;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class JobManager {
    private LinkedHashMap<String,Employee> employees;
    private List<Job> jobs;
    private EventListener listener;

    public JobManager(EventListener listener) {
        this.employees = new LinkedHashMap<>();
        this.jobs = new ArrayList<>();
        this.listener=listener;
    }

    public void createStandartEmployee(String name){
        Employee employee=new StandartEmployee(name);
        this.employees.put(employee.getName(),employee);
    }
    public void createPartEmployee(String name){
        Employee employee=new PartTimeEmployee(name);
        this.employees.put(employee.getName(),employee);
    }

    public void createJob(String name,int hours,String employee){
        if(this.employees.containsKey(employee)){
            Employee empl=this.employees.get(employee);
            Job job=new Job(name,hours,empl);
            job.setListener(this.listener);
            this.jobs.add(job);
        }
    }
    public void status(){
        for (Job job : jobs) {
            System.out.println(job.toString());
        }
    }

    public void passWeek(){
        for (Job job : jobs) {
            job.update();
        }
        this.jobs.removeIf(x->x.getHoursRequired()<=0);
    }
}
