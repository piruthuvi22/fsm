package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Integer> {
    Agent findByFirstName(String FirstName);
    Agent findByLastName(String LastName);
    Agent findByEmail(String Email);
    Agent findByPhoneNumber(String PhoneNumber);

}
