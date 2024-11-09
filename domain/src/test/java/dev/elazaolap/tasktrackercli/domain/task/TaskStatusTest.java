package dev.elazaolap.tasktrackercli.domain.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskStatusTest {

    private String validStatusName;
    private String invalidStatusName;

    @BeforeEach
    void setUp() {
        this.validStatusName = Status.values()[Status.values().length - 1].getValue();
        this.invalidStatusName = "UNKNOWN_STATUS";
    }

    @AfterEach
    void tearDown() {
        this.validStatusName = null;
        this.invalidStatusName = null;
    }

    @Test
    void shouldCreateAValidTaskStatus() {
        TaskStatus taskStatus = new TaskStatus(this.validStatusName);

        assertNotNull(taskStatus);
        assertTrue(taskStatus.isValid());
        assertNull(taskStatus.getErrorMessage());
    }

    @Test
    void shouldCreateAInvalidTaskStatus() {
        TaskStatus taskStatus = new TaskStatus(this.invalidStatusName);

        assertNotNull(taskStatus);
        assertFalse(taskStatus.isValid());
        assertNotNull(taskStatus.getErrorMessage());
    }
}