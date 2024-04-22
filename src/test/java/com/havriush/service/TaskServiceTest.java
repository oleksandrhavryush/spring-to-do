package com.havriush.service;

import com.havriush.dao.TaskDAO;
import com.havriush.domain.Status;
import com.havriush.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    TaskDAO taskDAO;

    @InjectMocks
    TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTasks_ReturnsListOfTasks() {
        // Arrange
        List<Task> tasks = new ArrayList<>();
        when(taskDAO.getAllTasks(anyInt(), anyInt())).thenReturn(tasks);

        // Act
        List<Task> result = taskService.getAllTasks(0, 10);

        // Assert
        assertEquals(tasks, result);
    }

    @Test
    void getAllTasksCount_ReturnsTaskCount() {
        // Arrange
        int count = 10;
        when(taskDAO.getAllTasksCount()).thenReturn(count);

        // Act
        int result = taskService.getAllTasksCount();

        // Assert
        assertEquals(count, result);
    }

    @Test
    void getTaskById_ReturnsTaskById() {
        // Arrange
        int id = 1;
        Task task = new Task();
        when(taskDAO.getTaskById(id)).thenReturn(task);

        // Act
        Task result = taskService.getTaskById(id);

        // Assert
        assertEquals(task, result);
    }

    @Test
    @Transactional
    void updateTask_UpdatesTask() {
        // Arrange
        int id = 1;
        String description = "Updated Description";
        Status status = Status.IN_PROGRESS;
        Task task = new Task();
        when(taskDAO.getTaskById(id)).thenReturn(task);

        // Act
        Task result = taskService.updateTask(id, description, status);

        // Assert
        assertEquals(description, result.getDescription());
        assertEquals(status, result.getStatus());
        verify(taskDAO, times(1)).saveOrUpdateTask(task);
    }

    @Test
    void createTask_CreatesTask() {
        // Arrange
        String description = "New Task";
        Status status = Status.DONE;
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);

        // Act
        taskService.createTask(description, status);

        // Assert
        verify(taskDAO, times(1)).saveOrUpdateTask(argThat(t -> t.getDescription().equals(description) && t.getStatus() == status));
    }


    @Test
    @Transactional
    void deleteTaskById_DeletesTask() {
        // Arrange
        int id = 1;

        // Act
        taskService.deleteTaskById(id);

        // Assert
        verify(taskDAO, times(1)).deleteTask(id);
    }
}
