package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Agent;
import com.freshkeys.fsm.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentService service;

    @PostMapping("/add-agent")
    public Agent addAgent(@RequestBody Agent agent) {
        return service.saveAgent(agent);
    }

    @GetMapping("/get-agents")
    public List<Agent> getAllAgents() {
        return service.getAgents();
    }

    @GetMapping("/get-agent-by-id/{id}")
    public Agent getAgentById(@PathVariable int id) {return service.getAgentById(id);}

    @GetMapping("/get-agent-by-firstname/{firstName}")
    public Agent getAgentByFirstName(@PathVariable String firstName) {return service.getAgentByFirstName(firstName);}

    @GetMapping("/get-agent-by-lastname/{lastName}")
    public Agent getAgentByLastName(@PathVariable String lastName) {return service.getAgentByLastName(lastName);}

    @GetMapping("/get-agent-by-email/{email}")
    public Agent getAgentByEmail(@PathVariable String email) {return service.getAgentByEmail(email);}

    @GetMapping("/get-agent-by-phonenumber/{phoneNumber}")
    public Agent getAgentByPhoneNumber(@PathVariable String phoneNumber) {return service.getAgentByPhoneNumber(phoneNumber);}

    @PutMapping("/update-agent")
    public Agent updateAgent(@RequestBody Agent agent) {
        return service.updateAgent(agent);
    }

    @DeleteMapping("/delete-agent/{id}")
    public String deleteAgent(@PathVariable int id) {
        return service.deleteAgent(id);
    }

}

