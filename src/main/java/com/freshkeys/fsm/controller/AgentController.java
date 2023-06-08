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

    @PostMapping("/add-agent")
    public List<Agent> addAgent(@RequestBody List<Agent> agent) {
        return service.saveAgent(agent);
    }

    @GetMapping("/get-agent")
    public List<Agent> getAllAgent() {
        return service.getAgent();
    }

    @GetMapping("/get-agent-by-id/{id}")
    public Agent getAgentById(@PathVariable int id) {return service.getAgentById(id);}

    @GetMapping("/get-agent-by-firstname/{firstname}")
    public Agent getAgentByFirstName(@PathVariable String FirstName) {return service.getAgentByFirstName(FirstName);}

    @GetMapping("/get-agent-by-lastname/{lastname}")
    public Agent getAgentByLastName(@PathVariable String LastName) {return service.getAgentByLastName(LastName);}

    @GetMapping("/get-agent-by-email/{email}")
    public Agent getAgentByEmail(@PathVariable String Email) {return service.getAgentByEmail(Email);}

    @GetMapping("/get-agent-by-phonenumber/{phonenumber}")
    public Agent getAgentByPhoneNumber(@PathVariable String PhoneNumber) {return service.getAgentByPhoneNumber(PhoneNumber);}

    @PutMapping("/update-agent")
    public Agent updateAgent(@RequestBody Agent agent) {
        return service.updateAgent(agent);
    }

    @DeleteMapping("/delete-agent/{id}")
    public String deleteAgent(@PathVariable int id) {
        return service.deleteAgent(id);
    }

}

