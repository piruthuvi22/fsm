package com.freshkeys.fsm.service;

import com.freshkeys.fsm.ResponseModel.TaskModel;
import com.freshkeys.fsm.ResponseModel.TaskStatusModel;
import com.freshkeys.fsm.entity.Task;
import com.freshkeys.fsm.entity.TaskNote;
import com.freshkeys.fsm.enums.TaskStatusEnum;
import com.freshkeys.fsm.repository.TaskNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskNoteService {
    @Autowired
    private TaskNoteRepository repository;

    // GET TASK NOTES
    public List<TaskNote> getTaskNotes(int taskId) {
        return repository.findAllByTaskId(taskId);
    }

    // ADD TASK NOTE
    public ResponseEntity<TaskNote> saveTaskNote(TaskNote taskNote) {
        return ResponseEntity.ok(repository.save(taskNote));
    }

    public ResponseEntity<?> updateTaskNote(TaskNote taskNote) {

        TaskNote existingTaskNote = repository.findById(taskNote.getId()).orElse(null);
        if (existingTaskNote != null) {
            return ResponseEntity.ok(repository.save(taskNote));
        } else {

            String errorMessage = "Task note with id " + taskNote.getId() + " not found";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    public ResponseEntity<?> deleteTaskNote(int id) {
        TaskNote existingTaskNote = repository.findById(id).orElse(null);
        if (existingTaskNote == null) {
            return ResponseEntity.ofNullable("Task note with id " + id + " not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Task note removed " + id);
    }


}
