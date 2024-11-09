package dev.ealzaolap.tasktrackercli.usecases.task;

import dev.elazaolap.tasktrackercli.domain.task.Task;
import dev.elazaolap.tasktrackercli.domain.task.TaskRepository;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryTaskRepository implements TaskRepository {
    private Map<TaskId, Task> tasks;

    private InMemoryTaskRepository() {
        this.tasks = new HashMap<>();
    }

    private InMemoryTaskRepository(Map<TaskId, Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void save(Task task) {
        this.tasks.put(task.getTaskId(), task);
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return tasks.containsKey(id) ? Optional.of(tasks.get(id)) : Optional.empty();
    }

    public static InMemoryTaskRepository buildEmptyRepository() {
        return new InMemoryTaskRepository();
    }

    public static InMemoryTaskRepository buildWith(Task... tasks) {
        InMemoryTaskRepository repository = new InMemoryTaskRepository();
        for (Task task : tasks) {
            repository.save(task);
        }

        return repository;
    }
}
