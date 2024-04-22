package com.havriush.controller;

import com.havriush.domain.Task;
import com.havriush.exception.*;
import com.havriush.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    TaskService taskService;

    @InjectMocks
    TaskController taskController;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTasks_ReturnsTasksPage() {
        // Arrange
        List<Task> tasks = new ArrayList<>();
        when(taskService.getAllTasks(anyInt(), anyInt())).thenReturn(tasks);

        // Act
        String viewName = taskController.getAllTasks(model, 1, 10);

        // Assert
        assertEquals("tasks", viewName);
        verify(model).addAttribute("taskList", tasks);
    }

    @Test
    void updateTask_ReturnsRedirectToTaskPage() {
        // Arrange
        int id = 1;
        TaskRequestDTO taskRequestDTO = new TaskRequestDTO();
        Task task = new Task();
        when(taskService.updateTask(id, taskRequestDTO.getDescription(), taskRequestDTO.getStatus())).thenReturn(task);

        // Act
        String viewName = taskController.updateTask(model, id, taskRequestDTO);

        // Assert
        assertEquals("redirect:/tasks/" + id, viewName);
        verify(model).addAttribute("task", task);
    }

    @Test
    void createTask_ReturnsRedirectToTaskPage() {
        // Arrange
        TaskRequestDTO taskRequestDTO = new TaskRequestDTO();
        Task task = new Task();
        when(taskService.createTask(taskRequestDTO.getDescription(), taskRequestDTO.getStatus())).thenReturn(task);

        // Act
        String viewName = taskController.createTask(model, taskRequestDTO);

        // Assert
        assertEquals("redirect:/tasks/" + task.getId(), viewName);
        verify(model).addAttribute("task", task);
    }

    @Test
    void delete_ThrowsException() {
        // Arrange
        int id = 1;
        doThrow(TaskDeletionException.class).when(taskService).deleteTaskById(id);

        // Act & Assert
        assertThrows(TaskDeletionException.class, () -> taskController.delete(model, id));
    }
}
