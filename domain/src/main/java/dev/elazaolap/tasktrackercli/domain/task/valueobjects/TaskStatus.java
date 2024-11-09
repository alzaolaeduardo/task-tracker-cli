package dev.elazaolap.tasktrackercli.domain.task.valueobjects;

public class TaskStatus extends TaskProperties<Status> {

    public TaskStatus(String value) {
        super(Status.valueOfLabel(value));
    }

    @Override
    boolean validate(Status value) {
        return value != null;
    }
}
