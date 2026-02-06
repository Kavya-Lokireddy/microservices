package com.microservice.task_service.service;


import com.microservice.task_service.dto.CreateTaskRequest;
import com.microservice.task_service.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}
