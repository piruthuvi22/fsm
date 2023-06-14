package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Supervisor;
import com.freshkeys.fsm.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SupervisorController {
    @Autowired
    private SupervisorService service;

    @PostMapping("/add-supervisor")
    public Supervisor addSupervisor(@RequestBody Supervisor supervisor) {
        return service.saveSupervisor(supervisor);
    }

    @GetMapping("/get-supervisors")
    public List<Supervisor> getAllSupervisors() {
        return service.getSupervisors();
    }

    @GetMapping("/get-supervisor-by-id/{id}")
    public Supervisor getSupervisorById(@PathVariable int id) {
        return service.getSupervisorById(id);
    }

    @PutMapping("/update-supervisor")
    public Supervisor updateSupervisor(@RequestBody Supervisor supervisor) {
        return service.updateSupervisor(supervisor);
    }

    @DeleteMapping("/delete-supervisor/{id}")
    public String deleteSupervisor(@PathVariable int id) {
        return service.deleteSupervisor(id);
    }
}
