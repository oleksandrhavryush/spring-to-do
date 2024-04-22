package com.havriush.controller;

import com.havriush.domain.Task;
import com.havriush.exception.TaskCreationException;
import com.havriush.exception.TaskDeletionException;
import com.havriush.exception.TaskListNotFoundException;
import com.havriush.exception.TaskNotFoundException;
import com.havriush.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public String getAllTasks(Model model,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Task> taskList = taskService.getAllTasks((page - 1) * limit, limit);
        if (taskList == null) {
            throw new TaskListNotFoundException("Task list not found");
        }
        model.addAttribute("taskList", taskList);
        model.addAttribute("current_page", page);
        int totalPages = (int) Math.ceil(1.0 * taskService.getAllTasksCount() / limit);
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("page_numbers", pageNumbers);
        }
        return "tasks";
    }

    @PostMapping("/{id}")
    public String updateTask(Model model,
                             @PathVariable Integer id,
                             @RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = taskService.updateTask(id, taskRequestDTO.getDescription(), taskRequestDTO.getStatus());
        if (task == null) {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }
        model.addAttribute("task", task);

        return "redirect:/tasks/" + id;
    }

    @PostMapping("/")
    public String createTask(Model model,
                             @RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = taskService.createTask(taskRequestDTO.getDescription(), taskRequestDTO.getStatus());
        if (task == null) {
            throw new TaskCreationException("Task could not be created");
        }
        model.addAttribute("task", task);
        return "redirect:/tasks/" + task.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {
        try {
            taskService.deleteTaskById(id);
        } catch (Exception e) {
            throw new TaskDeletionException("Task with id " + id + " could not be deleted");
        }
        return "tasks";
    }
}
