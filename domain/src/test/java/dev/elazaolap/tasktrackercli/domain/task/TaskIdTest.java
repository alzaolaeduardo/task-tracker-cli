package dev.elazaolap.tasktrackercli.domain.task;

import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskIdTest {

    private String goodId;
    private String badId;

    @BeforeEach
    void setUp() {
        goodId = UUID.randomUUID().toString();
        badId = "BAD_ID-" + UUID.randomUUID().toString();
    }

    @AfterEach
    void tearDown() {
        goodId = null;
        badId = null;
    }

    @Test
    void shouldCreateAValidTaskId() {
        TaskId taskId = new TaskId(goodId);

        assertNotNull(taskId);
        assertTrue(taskId.isValid());
        assertNull(taskId.getErrorMessage());
    }

    @Test
    void shouldCreateAInvalidTaskId() {
        TaskId taskId = new TaskId(badId);
        assertNotNull(taskId);
        assertFalse(taskId.isValid());
        assertNotNull(taskId.getErrorMessage());
    }
}