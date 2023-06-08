package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Integer> {
    Agent findByFirstname(String FirstName);
    Agent findByLastname(String LastName);
    Agent findByEmail(String Email);
    Agent findByPhonenumber(String PhoneNumber);

}
