package dev.ealzaolap.tasktrackercli.usecases.task;

import dev.ealzaolap.tasktrackercli.usecases.task.valueobjects.SaveTaskResult;
import dev.elazaolap.tasktrackercli.domain.task.Task;
import dev.elazaolap.tasktrackercli.domain.task.TaskRepository;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskDescription;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateTaskUseCaseTest {

    private CreateTaskUseCase createTaskUseCase;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = InMemoryTaskRepository.buildEmptyRepository();
        createTaskUseCase = new CreateTaskUseCase(taskRepository);
    }

    @AfterEach
    void tearDown() {
        taskRepository = null;
        createTaskUseCase = null;
    }

    @Test
    void shouldCreateTask() {
        String taskId = UUID.randomUUID().toString();
        String taskDescription = "VALID TASK";

        SaveTaskResult saveTaskResult = createTaskUseCase.execute(taskId, taskDescription);
        assertNotNull(saveTaskResult);
        assertTrue(saveTaskResult.isSuccess());
        assertEquals(saveTaskResult.getResult(), taskId);
    }

    @Test
    void shouldNotCreateTaskWhenTaskIdIsNull() {
        String taskDescription = "VALID TASK";
        SaveTaskResult saveTaskResult = createTaskUseCase.execute(null, taskDescription);

        assertNotNull(saveTaskResult);
        assertFalse(saveTaskResult.isSuccess());
        assertEquals(saveTaskResult.getErrorMessage(), SaveTaskResult.ILLEGAL_TASK_ID_MESSAGE + "null");
        assertNull(saveTaskResult.getResult());
    }

    @Test
    void shouldNotCreateTaskWhenTaskDescriptionIsNull() {
        SaveTaskResult saveTaskResult = createTaskUseCase.execute(UUID.randomUUID().toString(), null);

        assertNotNull(saveTaskResult);
        assertFalse(saveTaskResult.isSuccess());
        assertEquals(saveTaskResult.getErrorMessage(), SaveTaskResult.ILLEGAL_TASK_DESCRIPTION_MESSAGE + "null");
        assertNull(saveTaskResult.getResult());

    }

    @Test
    void shouldNotCreateTaskWhenTaskAlreadyExists() {
        String taskId = UUID.randomUUID().toString();
        String taskDescription = "VALID TASK";
        Task task = new Task(new TaskId(taskId), new TaskDescription(taskDescription));

        taskRepository = InMemoryTaskRepository.buildWith(task);
        createTaskUseCase = new CreateTaskUseCase(taskRepository);

        SaveTaskResult saveTaskResult = createTaskUseCase.execute(taskId, taskDescription);
        assertNotNull(saveTaskResult);
        assertFalse(saveTaskResult.isSuccess());
        assertEquals(saveTaskResult.getErrorMessage(), SaveTaskResult.TASK_ALREADY_EXIST_MESSAGE);
        assertNull(saveTaskResult.getResult());
    }
}