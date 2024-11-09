package dev.elazaolap.tasktrackercli.domain.task;

import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskDescription;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskDescriptionTest {

    private String description;

    @BeforeEach
    void setUp() {
        this.description = "Task Description - " + UUID.randomUUID();
    }

    @AfterEach
    void tearDown() {
        this.description = null;
    }

    @Test
    void shouldCreateAValidTaskDescription() {
        TaskDescription taskDescription = new TaskDescription(description);
        assertNotNull(taskDescription);
        assertTrue(taskDescription.isValid());
        assertNull(taskDescription.getErrorMessage());
    }

    @Test
    void shouldCreateAInvalidTaskDescriptionWithNullDescription() {
        TaskDescription taskDescription = new TaskDescription(null);
        assertNotNull(taskDescription);
        assertFalse(taskDescription.isValid());
        assertNotNull(taskDescription.getErrorMessage());
    }

    @Test
    void shouldCreateAInvalidTaskDescriptionWithEmptyDescription() {
        TaskDescription taskDescription = new TaskDescription("");
        assertNotNull(taskDescription);
        assertFalse(taskDescription.isValid());
        assertNotNull(taskDescription.getErrorMessage());
    }
}