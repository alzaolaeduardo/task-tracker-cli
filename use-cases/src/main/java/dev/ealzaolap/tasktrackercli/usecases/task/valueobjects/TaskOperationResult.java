package dev.ealzaolap.tasktrackercli.usecases.task.valueobjects;

public abstract class TaskOperationResult<T> {

    private final boolean success;
    private final T result;
    private final String errorMessage;

    protected TaskOperationResult(boolean success, T result, String errorMessage) {
        this.success = success;
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
