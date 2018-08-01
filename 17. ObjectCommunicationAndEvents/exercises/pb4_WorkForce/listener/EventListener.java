package pb4_WorkForce.listener;

import pb4_WorkForce.models.JobDoneEvent;

public interface EventListener {
    void handle(JobDoneEvent event);
}
