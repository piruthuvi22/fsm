package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Agent;
import com.freshkeys.fsm.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    private AgentRepository repository;

    public Agent saveAgent(Agent agent){
        return repository.save(agent);
    }

    public List<Agent> saveAgent(List<Agent> agent){
        return repository.saveAll(agent);
    }

    public List<Agent> getAgent(){
        return repository.findAll();
    }

    public Agent getAgentById(int id){
        return repository.findById(id).orElse(null);
    }

    public Agent getAgentByFirstName(String FirstName){return repository.findByFirstName(FirstName);}

    public Agent getAgentByLastName(String LastName){
        return repository.findByLastName(LastName);
    }

    public Agent getAgentByEmail(String Email){
        return repository.findByEmail(Email);
    }

    public Agent getAgentByPhoneNumber(String PhoneNumber){
        return repository.findByPhoneNumber(PhoneNumber);
    }




    public String deleteAgent(int id){
        repository.deleteById(id);
        return "Agent removed " + id;
    }

    public Agent updateAgent(Agent agent){

        Agent existingAgent = repository.findById(agent.getId()).orElse(null);
        existingAgent.setFirstName(agent.getFirstName());
        existingAgent.setLastName(agent.getLastName());
        existingAgent.setEmail(agent.getEmail());
        existingAgent.setPhoneNumber(agent.getPhoneNumber());


        return repository.save(existingAgent);
    }
}
