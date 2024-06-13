package com.example.taskmanagement.repository.impl;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@ConditionalOnProperty(name = "task.repository.type", havingValue = "in-memory")
public class InMemoryTaskRepositoryImpl implements TaskRepository {

    private final Map<Long, Task> db = new HashMap<>();
    private static Long genId = 1L;

    @Override
    public Task save(Task task) {
        task.setId(genId++);
        db.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        if (!db.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(db.get(id));
    }

    @Override
    public void delete(Task id) {
        db.remove(id);
    }

    @Override
    public List<Task> findAll() {
        return db.values().stream().toList();
    }
}
