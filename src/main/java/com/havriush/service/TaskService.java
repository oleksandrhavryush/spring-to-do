package com.havriush.service;

import com.havriush.dao.TaskDAO;
import com.havriush.domain.Status;
import com.havriush.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskDAO taskDAO;

    public List<Task> getAllTasks(int offset, int limit) {
        return taskDAO.getAllTasks(offset, limit);
    }

    public int getAllTasksCount() {
        return taskDAO.getAllTasksCount();
    }

    public Task getTaskById(int id) {
        return taskDAO.getTaskById(id);
    }

    @Transactional
    public Task updateTask(int id, String description, Status status) {
        Task task = taskDAO.getTaskById(id);
        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdateTask(task);
        return task;
    }

    public Task createTask(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdateTask(task);
        return task;
    }

    @Transactional
    public void deleteTaskById(int id) {
        taskDAO.deleteTask(id);
    }
}
