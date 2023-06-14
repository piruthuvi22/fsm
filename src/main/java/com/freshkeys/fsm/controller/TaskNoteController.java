package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.ResponseModel.TaskModel;
import com.freshkeys.fsm.ResponseModel.TaskStatusModel;
import com.freshkeys.fsm.entity.Task;
import com.freshkeys.fsm.entity.TaskNote;
import com.freshkeys.fsm.service.TaskNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // allow all origins
public class TaskNoteController {
    @Autowired
    private TaskNoteService service;

    @GetMapping("/get-task-notes/{taskId}")
    public List<TaskNote> getTaskNotes(@PathVariable int taskId) {
        return service.getTaskNotes(taskId);
    }


    // ADD TASK NOTE
    @PostMapping("/add-task-note")
    public ResponseEntity<TaskNote> addTask(@RequestBody TaskNote taskNote) {
        System.out.println("taskNote: " + taskNote.toString() );

        return service.saveTaskNote(taskNote);
    }

    // UPDATE TASK NOTE
    @PutMapping("/update-task-note")
    public ResponseEntity<?> updateTaskNote(@RequestBody TaskNote taskNote) {
        return service.updateTaskNote(taskNote);
    }

    // DELETE TASK NOTE
    @DeleteMapping("/delete-task-note/{id}")
    public ResponseEntity<?> deleteTaskNote(@PathVariable int id) {
        return service.deleteTaskNote(id);
    }


}

