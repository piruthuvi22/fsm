package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Complaint;
import com.freshkeys.fsm.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository repository;

    public ResponseEntity<?> saveComplaint(Complaint complaint) {
        if (complaint.getTaskid() == 0) {
            String errorMessage = "Customer id is required";
            return ResponseEntity.badRequest().body(errorMessage);
        } else {
            return ResponseEntity.ok(repository.save(complaint));
        }

    }

    public List<Complaint> getComplaints() {
        return repository.findAll();
    }

    public Complaint getComplaintById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteComplaint(int id) {
        Complaint existingComplaint = repository.findById(id).orElse(null);
        if (existingComplaint == null) {
            return ResponseEntity.ofNullable("Complaint with id " + id + " not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Complaint removed " + id);
    }

    public ResponseEntity<?> updateComplaint(Complaint complaint) {

        Complaint existingComplaint = repository.findById(complaint.getId()).orElse(null);
        if (existingComplaint != null) {
            return ResponseEntity.ok(repository.save(complaint));
        } else {

            String errorMessage = "Complaint with id " + complaint.getId() + " not found";
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    public Complaint markComplaintHandled(int id) {
        Complaint complaint = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Complaint not found with id: " + id));

        complaint.setHandled(true);
        return repository.save(complaint);
    }

    public Complaint markAgentActivated(int id) {
        Complaint complaint = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Complaint not found with id: " + id));

        complaint.setHandled(false);
        return repository.save(complaint);
    }


}
