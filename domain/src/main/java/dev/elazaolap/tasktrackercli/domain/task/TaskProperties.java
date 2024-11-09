package dev.elazaolap.tasktrackercli.domain.task;

import java.util.Objects;

public abstract class TaskProperties<T> {

    private final T value;
    private final boolean isValid;
    private final String errorMessage;

    protected TaskProperties(T value) {
        if (validate(value)) {
            this.value = value;
            this.isValid = true;
            this.errorMessage = null;
        } else {
            this.value = null;
            this.isValid = false;
            this.errorMessage = "Invalid value for build " + this.getClass().getCanonicalName();
        }
    }

    abstract boolean validate(T value);

    public T getValue() {
        return value;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskProperties<?> that)) return false;
        return isValid == that.isValid && Objects.equals(value, that.value) && Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isValid, errorMessage);
    }
}
