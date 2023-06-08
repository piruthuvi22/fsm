package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Supervisor;
import com.freshkeys.fsm.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {
    @Autowired
    private SupervisorRepository repository;

    public Supervisor saveSupervisor(Supervisor supervisor) {
        return repository.save(supervisor);
    }

    public List<Supervisor> getSupervisors() {
        return repository.findAll();
    }

    public Supervisor getSupervisorByPhonenumber(String phonenumber) {
        return repository.findByPhonenumber(phonenumber);
    }

    public Supervisor getSupervisorById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSupervisor(int id) {
        repository.deleteById(id);
        return "Supervisor removed: " + id;
    }

    public Supervisor updateSupervisor(Supervisor supervisor) {
        Supervisor existingSupervisor = repository.findById(supervisor.getId()).orElse(null);
        existingSupervisor.setFirstname(supervisor.getFirstname());
        existingSupervisor.setLastname(supervisor.getLastname());
        existingSupervisor.setEmail(supervisor.getEmail());
        existingSupervisor.setPhonenumber(supervisor.getPhonenumber());

        return repository.save(existingSupervisor);
    }
}
