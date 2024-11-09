package dev.elazaolap.tasktrackercli.domain.task;

import java.util.UUID;

public final class TaskId extends TaskProperties<String> {

    public TaskId(String value) {
        super(value);
    }

    @Override
    boolean validate(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
