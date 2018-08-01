package pb4_WorkForce.models;

import java.util.EventObject;

public class JobDoneEvent extends EventObject {
    private String jobName;

    public JobDoneEvent(Job source, String jobName) {
        super(source);
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }
}
