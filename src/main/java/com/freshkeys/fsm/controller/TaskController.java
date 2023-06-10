package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.ResponseModel.TaskWithCustomerName;
import com.freshkeys.fsm.entity.Task;
import com.freshkeys.fsm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // allow all origins
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping("/add-task")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        return service.saveTask(task);
    }

    @GetMapping("/get-tasks")
    public List<Task> getAllTasks() {
        return service.getTasks();
    }

    @GetMapping("/get-tasks/{agentId}")
    public List<Task> getAllTasksOfAgent(@PathVariable int agentId ) {
        return service.getAllTasksOfAgent(agentId);
    }

    @GetMapping("/get-task-by-id/{id}")
    public Task getTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }

    @PutMapping("/update-task")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return service.deleteTask(id);
    }

    @GetMapping("/task-with-customer-name")
    public ResponseEntity<List<TaskWithCustomerName>> getTasksWithCustomerName() {
        List<TaskWithCustomerName> tasks = service.getTasksWithCustomerName();
        return ResponseEntity.ok().body(tasks);
    }
}
