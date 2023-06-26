package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.TaskUpdate;
import com.freshkeys.fsm.enums.TaskUpdateEnum;
import com.freshkeys.fsm.service.TaskUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // allow all origins
public class TaskUpdateController {
    @Autowired
    private TaskUpdateService service;

    @GetMapping("/get-task-notes/{taskId}/{type}")
    public List<TaskUpdate> getTaskNotes(@PathVariable int taskId, @PathVariable TaskUpdateEnum type) {
        return service.getTaskNotes(taskId,type);
    }


    // ADD TASK NOTE
    @PostMapping("/add-task-note")
    public ResponseEntity<TaskUpdate> addTask(@RequestBody TaskUpdate taskNote) {
        System.out.println("taskNote: " + taskNote.toString() );

        return service.saveTaskNote(taskNote);
    }

    // UPDATE TASK NOTE
    @PutMapping("/update-task-note")
    public ResponseEntity<?> updateTaskNote(@RequestBody TaskUpdate taskNote) {
        return service.updateTaskNote(taskNote);
    }

    // DELETE TASK NOTE
    @DeleteMapping("/delete-task-note/{id}")
    public ResponseEntity<?> deleteTaskNote(@PathVariable int id) {
        return service.deleteTaskNote(id);
    }


}

