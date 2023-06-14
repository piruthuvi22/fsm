package com.freshkeys.fsm.repository;


import com.freshkeys.fsm.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
