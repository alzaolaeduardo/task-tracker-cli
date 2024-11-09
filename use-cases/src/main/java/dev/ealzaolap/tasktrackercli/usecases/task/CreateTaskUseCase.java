package dev.ealzaolap.tasktrackercli.usecases.task;

import dev.ealzaolap.tasktrackercli.usecases.task.valueobjects.SaveTaskResult;
import dev.elazaolap.tasktrackercli.domain.task.Task;
import dev.elazaolap.tasktrackercli.domain.task.TaskRepository;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskDescription;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;

public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public CreateTaskUseCase(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public SaveTaskResult execute(String id, String description) {
        TaskId taskId = new TaskId(id);
        TaskDescription taskDescription = new TaskDescription(description);

        if (!taskId.isValid() || !taskDescription.isValid()) {
            return  !taskId.isValid()
                    ? SaveTaskResult.errorIllegalTaskId(id)
                    : SaveTaskResult.errorIllegalDescription(description);
        }

        if (taskRepository.findById(taskId).isPresent()) {
            return SaveTaskResult.errorAlreadyExist();
        }

        Task newTask = new Task(taskId, taskDescription);

        taskRepository.save(newTask);
        return SaveTaskResult.success(id);
    }
}
