package com.havriush.controller;

import com.havriush.domain.Task;
import com.havriush.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("taskList", taskList);
        return "tasks";
    }

    @PostMapping("/{id}")
    public String updateTask(Model model,
                             @PathVariable Integer id,
                             @RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = taskService.updateTask(id, taskRequestDTO.getDescription(), taskRequestDTO.getStatus());
        model.addAttribute("task", task);

        return "redirect:/tasks/" + id;
    }

    @PostMapping("/")
    public String createTask(Model model,
                           @RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = taskService.createTask(taskRequestDTO.getDescription(), taskRequestDTO.getStatus());
        model.addAttribute("task", task);
        return "redirect:/tasks/" + task.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return "tasks";
    }
}