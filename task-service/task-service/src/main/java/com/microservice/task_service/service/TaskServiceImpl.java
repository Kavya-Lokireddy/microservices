package com.microservice.task_service.service;


import com.microservice.task_service.client.UserClient;
import com.microservice.task_service.dto.CreateTaskRequest;
import com.microservice.task_service.dto.UserDTO;
import com.microservice.task_service.exception.TaskNotFoundException;
import com.microservice.task_service.model.Task;
import com.microservice.task_service.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserClient userClient;

    public TaskServiceImpl(TaskRepository taskRepository,UserClient userClient) {
        this.taskRepository = taskRepository;
        this.userClient=userClient;
    }

    public Task createTask(CreateTaskRequest request) {

        // 🔥 Feign call to user-service
        UserDTO user = userClient.getUserById(request.getAssigneeId());

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAssigneeId(user.getId());
        task.setCompleted(false);

        return taskRepository.save(task);
    }
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existingTask = getTaskById(id);

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.isCompleted());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
