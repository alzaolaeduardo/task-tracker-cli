package dev.elazaolap.tasktrackercli.domain.task;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    private static final Map<String, Status> BY_LABEL = new HashMap<>();

    static {
        for (Status e: values()) {
            BY_LABEL.put(e.value, e);
        }
    }

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
