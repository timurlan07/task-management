package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    void delete(Task id);

    List<Task> findAll();

}
