package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {

    Supervisor findByPhonenumber(String phonenumber);


}
