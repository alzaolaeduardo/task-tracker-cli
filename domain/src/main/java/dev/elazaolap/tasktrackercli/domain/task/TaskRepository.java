package dev.elazaolap.tasktrackercli.domain.task;

import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;

import java.util.Optional;

public interface TaskRepository {
    void save(Task task);

    Optional<Task> findById(TaskId id);
}
