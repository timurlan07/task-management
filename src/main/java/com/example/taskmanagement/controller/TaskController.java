package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.dto.TaskRequest;
import com.example.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Task")
@RequiredArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Create Task")
    @PostMapping
    public Task createTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @Operation(summary = "Update Task")
    @PutMapping("/{id}")
    public Task udpateTask(@PathVariable("id") Long taskId, @RequestBody TaskRequest request) {
        return taskService.updateTaskById(taskId, request);
    }

    @Operation(summary = "Delete Task by task id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Long taskId) {
        return taskService.deleteTaskById(taskId);
    }

    @Operation(summary = "Get Task by task id")
    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
