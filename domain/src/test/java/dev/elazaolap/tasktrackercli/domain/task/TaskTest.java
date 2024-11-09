package dev.elazaolap.tasktrackercli.domain.task;

import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskDescription;
import dev.elazaolap.tasktrackercli.domain.task.valueobjects.TaskId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private TaskId commonTaskId;
    private TaskDescription commonTaskDescription;
    private Task taskOne;
    private Task taskTwo;

    @BeforeEach
    void setUp() {
        this.commonTaskId = new TaskId(UUID.randomUUID().toString());
        this.commonTaskDescription = new TaskDescription("SAME TASK");

        taskOne = new Task(this.commonTaskId, this.commonTaskDescription);
        taskTwo = new Task(this.commonTaskId, this.commonTaskDescription);
    }

    @AfterEach
    void tearDown() {
        commonTaskId = null;
        commonTaskDescription = null;
        taskOne = null;
        taskTwo = null;
    }

    @Test
    void shouldBeEqual(){
        assertEquals(taskOne, taskTwo);
        assertEquals(taskOne.hashCode(), taskTwo.hashCode());
        assertNotEquals(taskOne.getCreatedAt(), taskTwo.getCreatedAt());
    }

    @Test
    void shouldNotBeEqual(){
        taskOne = new Task(this.commonTaskId, this.commonTaskDescription);
        taskTwo = new Task(this.commonTaskId, new TaskDescription("OTHER TASK"));

        assertNotEquals(taskOne, taskTwo);
        assertNotEquals(taskOne.hashCode(), taskTwo.hashCode());

    }
}