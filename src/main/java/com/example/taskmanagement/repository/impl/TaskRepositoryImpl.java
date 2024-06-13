package com.example.taskmanagement.repository.impl;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.JpaTaskRepository;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@ConditionalOnProperty(name = "task.repository.type", havingValue = "database")
public class TaskRepositoryImpl implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {
        return jpaTaskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id);
    }

    @Override
    public void delete(Task id) {
        jpaTaskRepository.delete(id);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll();
    }
}