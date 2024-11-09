package dev.elazaolap.tasktrackercli.domain.task;

public final class TaskDescription extends TaskProperties<String> {

    public TaskDescription(String value) {
        super(value);
    }

    @Override
    boolean validate(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
