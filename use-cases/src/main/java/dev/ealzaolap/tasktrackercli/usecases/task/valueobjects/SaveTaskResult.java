package dev.ealzaolap.tasktrackercli.usecases.task.valueobjects;

public class SaveTaskResult extends TaskOperationResult<String> {

    public static final String TASK_ALREADY_EXIST_MESSAGE = "Task already exist";
    public static final String SAVING_TASK_FAILED_MESSAGE = "Saving task failed";
    public static final String ILLEGAL_TASK_ID_MESSAGE = "Illegal task id: ";
    public static final String ILLEGAL_TASK_DESCRIPTION_MESSAGE = "Illegal task description: ";

    private SaveTaskResult(boolean success, String result, String errorMessage) {
        super(success, result, errorMessage);
    }

    public static SaveTaskResult success(String taskId) {
        return new SaveTaskResult(true, taskId, null);
    }

    public static SaveTaskResult errorAlreadyExist() {
        return new SaveTaskResult(false,  null, TASK_ALREADY_EXIST_MESSAGE);
    }

    public static SaveTaskResult errorSavingTask() {
        return new SaveTaskResult(false,  null, SAVING_TASK_FAILED_MESSAGE);
    }

    public static SaveTaskResult errorIllegalTaskId(String taskId) {
        return new SaveTaskResult(false, null, ILLEGAL_TASK_ID_MESSAGE + taskId);
    }

    public static SaveTaskResult errorIllegalDescription(String taskDescription) {
        return new SaveTaskResult(false, null, ILLEGAL_TASK_DESCRIPTION_MESSAGE + taskDescription);
    }
}
