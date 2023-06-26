package com.freshkeys.fsm.service;

import com.freshkeys.fsm.ResponseModel.TaskModel;
import com.freshkeys.fsm.ResponseModel.TaskStatusModel;
import com.freshkeys.fsm.entity.Task;
import com.freshkeys.fsm.enums.TaskStatusEnum;
import com.freshkeys.fsm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public ResponseEntity<?> saveTask(Task task) {
        if (task.getCustomerPhoneNumber() == null) {
            String errorMessage = "Customer PhoneNumber is required";
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

    public List<TaskModel> getTasksWithCustomerName() {
        return repository.findTasksWithCustomerName();
    }


    public List<?> getAllTasksOfAgent(int agentId) {
        System.out.println("================");

        return repository.getAllTasksOfAgent(agentId);
    }

    public List<TaskModel> getAssignedTasksOfAgents(int agentId) {
        return repository.getAssignedTasksOfAgent(agentId);
    }

    public List<TaskModel> getProgressedTasksOfAgents(int agentId) {
        return repository.getProgressedTasksOfAgent(agentId);
    }

    public List<TaskModel> getCompletedTasksOfAgents(int agentId) {
        return repository.getCompletedTasksOfAgent(agentId);
    }

    //REJECT TASk
    public ResponseEntity<TaskStatusModel> rejectTask(int taskId) {
        Task existingTask = repository.findById(taskId).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(TaskStatusEnum.valueOf("REJECTED"));
            repository.save(existingTask);
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(existingTask.getId());
            taskStatusModel.setStatus(TaskStatusEnum.REJECTED);
            taskStatusModel.setMessage("Task rejected");
            return ResponseEntity.ok(taskStatusModel);
        } else {
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(taskId);
            taskStatusModel.setMessage("Task with id " + taskId + " not found");
            return ResponseEntity.badRequest().body(taskStatusModel);
        }
    }

    // ACCEPT TASK
    public ResponseEntity<TaskStatusModel> acceptTask(int taskId) {
        Task existingTask = repository.findById(taskId).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(TaskStatusEnum.valueOf("PROGRESS"));
            repository.save(existingTask);
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(existingTask.getId());
            taskStatusModel.setStatus(TaskStatusEnum.PROGRESS);
            taskStatusModel.setMessage("Task accepted");
            return ResponseEntity.ok(taskStatusModel);
        } else {
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(taskId);
            taskStatusModel.setMessage("Task with id " + taskId + " not found");
            return ResponseEntity.badRequest().body(taskStatusModel);
        }
    }


    // COMPLETE TASK
    public ResponseEntity<TaskStatusModel> completeTask(int taskId) {
        Task existingTask = repository.findById(taskId).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(TaskStatusEnum.valueOf("COMPLETED"));
            repository.save(existingTask);
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(existingTask.getId());
            taskStatusModel.setStatus(TaskStatusEnum.COMPLETED);
            taskStatusModel.setMessage("Task marked as completed");
            return ResponseEntity.ok(taskStatusModel);
        } else {
            TaskStatusModel taskStatusModel = new TaskStatusModel();
            taskStatusModel.setId(taskId);
            taskStatusModel.setMessage("Task with id " + taskId + " not found");
            return ResponseEntity.badRequest().body(taskStatusModel);
        }
    }
    public Task findByCustomerphonenumber(String phoneNumber) {
        return repository.findByCustomerPhoneNumber(phoneNumber);}

}
