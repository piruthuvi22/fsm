package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.TaskUpdate;
import com.freshkeys.fsm.enums.TaskUpdateEnum;
import com.freshkeys.fsm.repository.TaskUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskUpdateService {
    @Autowired
    private TaskUpdateRepository repository;

    // GET TASK NOTES
    public List<TaskUpdate> getTaskNotes(int taskId, TaskUpdateEnum type) {
        return repository.findAllByTaskIdAndType(taskId, type);
    }

    // ADD TASK NOTE
    public ResponseEntity<TaskUpdate> saveTaskNote(TaskUpdate taskNote) {
        return ResponseEntity.ok(repository.save(taskNote));
    }

    public ResponseEntity<?> updateTaskNote(TaskUpdate taskNote) {

        TaskUpdate existingTaskNote = repository.findById(taskNote.getId()).orElse(null);
        if (existingTaskNote != null) {
            return ResponseEntity.ok(repository.save(taskNote));
        } else {

            String errorMessage = "Task note with id " + taskNote.getId() + " not found";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    public ResponseEntity<?> deleteTaskNote(int id) {
        TaskUpdate existingTaskNote = repository.findById(id).orElse(null);
        if (existingTaskNote == null) {
            return ResponseEntity.ofNullable("Task note with id " + id + " not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Task note removed " + id);
    }


}
