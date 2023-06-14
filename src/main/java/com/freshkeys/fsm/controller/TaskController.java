package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.ResponseModel.TaskModel;
import com.freshkeys.fsm.ResponseModel.TaskStatusModel;
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

//    @GetMapping("/get-tasks/{agentId}")
//    public List<Task> getAllTasksOfAgent(@PathVariable int agentId ) {
//        return service.getAllTasksOfAgent(agentId);
//    }

    @GetMapping("/get-task-by-id/{id}")
    public Task getTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }

    @PutMapping("/update-task")
    public ResponseEntity<?
            > updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return service.deleteTask(id);
    }

    @GetMapping("/task-with-customer-name")
    public ResponseEntity<List<TaskModel>> getTasksWithCustomerName() {
        List<TaskModel> tasks = service.getTasksWithCustomerName();
        return ResponseEntity.ok().body(tasks);
    }


    @GetMapping("/get-tasks/{agentId}")
    public ResponseEntity<List<TaskModel>> getTasksOfAgents(@PathVariable int agentId) {
        List<TaskModel> tasks = service.getAllTasksOfAgent(agentId);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/get-assigned/{agentId}")
    public ResponseEntity<List<TaskModel>> getAssignedTasksOfAgents(@PathVariable int agentId) {
        List<TaskModel> tasks = service.getAssignedTasksOfAgents(agentId);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/get-progressed/{agentId}")
    public ResponseEntity<List<TaskModel>> getProgressedTasksOfAgents(@PathVariable int agentId) {
        List<TaskModel> tasks = service.getProgressedTasksOfAgents(agentId);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/get-completed/{agentId}")
    public ResponseEntity<List<TaskModel>> getCompletedTasksOfAgents(@PathVariable int agentId) {
        List<TaskModel> tasks = service.getCompletedTasksOfAgents(agentId);
        return ResponseEntity.ok().body(tasks);
    }

    // REJECT TASK
    @PutMapping("/task-reject/{taskId}")
    public ResponseEntity<TaskStatusModel> rejectTask(@PathVariable int taskId) {
        return service.rejectTask(taskId);
    }

    // ACCEPT TASK
    @PutMapping("/task-accept/{taskId}")
    public ResponseEntity<TaskStatusModel> acceptTask(@PathVariable int taskId) {
        return service.acceptTask(taskId);
    }


    // ACCEPT TASK
    @PutMapping("/task-complete/{taskId}")
    public ResponseEntity<TaskStatusModel> completeTask(@PathVariable int taskId) {
        return service.completeTask(taskId);
    }
    @GetMapping("/phonetask/{phonenumber}")
    public Task getTaskByPhoneNumber(@PathVariable String phonenumber) {
        return service.findByCustomerphonenumber(phonenumber);
}

}

