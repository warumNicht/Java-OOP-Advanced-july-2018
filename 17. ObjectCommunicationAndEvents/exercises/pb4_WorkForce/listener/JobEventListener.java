package pb4_WorkForce.listener;

import pb4_WorkForce.models.JobDoneEvent;

public class JobEventListener implements EventListener {
    @Override
    public void handle(JobDoneEvent event) {
        System.out.println(String.format("Job %s done!",event.getJobName()));
    }
}
