package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Complaint;
import com.freshkeys.fsm.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // allow all origins
public class ComplaintController {
    @Autowired
    private ComplaintService service;

    @PostMapping("/add-complaint")
    public ResponseEntity<?> addComplaint(@RequestBody Complaint complaint) {
        return service.saveComplaint(complaint);
    }

    @GetMapping("/get-complaints")
    public List<Complaint> getAllComplaints() {
        return service.getComplaints();
    }

    @GetMapping("/get-complaint-by-id/{id}")
    public Complaint getComplaintById(@PathVariable int id) {
        return service.getComplaintById(id);
    }

    @PutMapping("/update-complaint")
    public ResponseEntity<?> updateComplaint(@RequestBody Complaint complaint) {
        return service.updateComplaint(complaint);
    }


    @DeleteMapping("/delete-complaint/{id}")
    public ResponseEntity<?> deleteComplaint(@PathVariable int id) {
        return service.deleteComplaint(id);
    }


    @PutMapping("/{id}/update-handled")
    public Complaint markComplaintHandled(@PathVariable("id") int id) {
        return service.markComplaintHandled(id);
    }
}


