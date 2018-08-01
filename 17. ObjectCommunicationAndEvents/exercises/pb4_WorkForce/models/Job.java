package pb4_WorkForce.models;

import pb4_WorkForce.interfaces.Employee;
import pb4_WorkForce.listener.EventListener;

public class Job {
    private String name;
    private  int hoursRequired;
    private Employee employee;
    private EventListener listener;

    public Job(String name, int hoursRequired, Employee employee) {
        this.name = name;
        this.hoursRequired = hoursRequired;
        this.employee = employee;
    }

    public void setListener(EventListener listener) {
        this.listener = listener;
    }

    public int getHoursRequired() {
        return hoursRequired;
    }

    public void update(){
        this.hoursRequired-=this.employee.getWorkHoursPerWeek();
        if(this.hoursRequired<=0){
            this.listener.handle(new JobDoneEvent(this,this.name));
        }

    }
//
//    @Override
//    public int hashCode() {
//        return this.name.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return this.name.equals(((Job)obj).name);
//    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",
                this.name, this.hoursRequired);
    }
}
