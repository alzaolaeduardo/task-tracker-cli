package dev.elazaolap.tasktrackercli.domain.task;

import dev.elazaolap.tasktrackercli.domain.task.valueobjects.Status;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskDescription;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private final TaskId taskId;
    private final TaskDescription taskDescription;
    private final TaskStatus taskStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(TaskStatus taskStatus, LocalDateTime createdAt, TaskDescription taskDescription, TaskId taskId) {
        this.taskStatus = taskStatus;
        this.createdAt = createdAt;
        this.taskDescription = taskDescription;
        this.taskId = taskId;
    }

    public Task(TaskId taskId, TaskDescription taskDescription) {
        this (
                new TaskStatus(Status.TODO.getValue()),
                LocalDateTime.now(),
                taskDescription,
                taskId
        );
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(taskId, task.taskId) && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(taskStatus, task.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDescription, taskStatus);
    }
}
