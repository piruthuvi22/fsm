package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Task;
import com.freshkeys.fsm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public ResponseEntity<?> saveTask(Task task) {
        if (task.getCustomer_id() == 0) {
            String errorMessage = "Customer id is required";
            return ResponseEntity.badRequest().body(errorMessage);
        } else {
            return ResponseEntity.ok(repository.save(task));
        }

    }

    public List<Task> getTasks() {
        return repository.findAll();
    }

    public Task getTaskById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteTask(int id) {
        Task existingTask = repository.findById(id).orElse(null);
        if (existingTask == null) {
            return ResponseEntity.ofNullable("Task with id " + id + " not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Task removed " + id);
    }

    public ResponseEntity<?> updateTask(Task task) {

        Task existingTask = repository.findById(task.getId()).orElse(null);
        if (existingTask != null) {
            return ResponseEntity.ok(repository.save(task));
        } else {

            String errorMessage = "Task with id " + task.getId() + " not found";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
