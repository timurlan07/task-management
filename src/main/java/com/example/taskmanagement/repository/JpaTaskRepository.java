package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "task.repository.type", havingValue = "database")
public interface JpaTaskRepository extends JpaRepository<Task, Long> {
}
