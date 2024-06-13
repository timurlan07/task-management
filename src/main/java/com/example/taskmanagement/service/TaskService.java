package com.example.taskmanagement.service;

import com.example.taskmanagement.exception.NotFoundException;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.dto.TaskRequest;
import com.example.taskmanagement.model.mapper.TaskMapper;
import com.example.taskmanagement.repository.JpaTaskRepository;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс сервис. Используется для работы с бизнес логикой обьекта {@link Task}.
 * {@link RequiredArgsConstructor} создаёт конструктор с требуемыми аргументами
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Ипользуется для создания новой задачи и его логирования
     *
     * @param request аргумент типа {@link TaskRequest}
     * @return обьект типа {@link Task}
     */
    public Task createTask(TaskRequest request) {
        log.info("Task successfully saved!");
        return taskRepository.save(TaskMapper.mapTaskRequestToTask(request));
    }

    /**
     * Ипользуется для обновления задачи по ID его логирования
     *
     * @param taskId  аргемент типа {@link Long}
     * @param request аргуемента типа {@link TaskRequest}
     * @return обьект типа {@link Task},
     */
    public Task updateTaskById(Long taskId, TaskRequest request) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> {
            log.warn("Task not found by id = " + taskId);
            return new NotFoundException("Task not found by id = " + taskId);
        });
        task.setDescription(request.description());
        task.setDone(request.done());
        log.info("Task successfully updated!");
        return taskRepository.save(task);
    }

    /**
     * Ипользуется для удаления задачи по ID и его логирования
     *
     * @param taskId аргуемент типа ({@link Long})</p>
     * @return (NOT_FOUND) 200 статус код при успешном выполнении
     */
    public ResponseEntity<HttpStatus> deleteTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> {
            log.warn("Task not found by id = " + taskId);
            return new NotFoundException("Task not found by id = " + taskId);
        });
        taskRepository.delete(task);
        log.info("Task successfully deleted!");
        return ResponseEntity.ok().build();
    }

    /**
     * Ипользуется для получения задачи по ID и его логирования
     *
     * @param taskId аргуемент типа  ({@link Long})
     * @return обьект типа {@link Task} успешном выополнении
     */
    public Task getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> {
            log.warn("Task not found by id = " + taskId);
            return new NotFoundException("Task not found by id = " + taskId);
        });
        log.info("Task got = " + task.toString());
        return task;
    }

    /**
     * Ипользуется для получения всех задач
     *
     * @return возвращает список обьектов типа {@link Task}
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
