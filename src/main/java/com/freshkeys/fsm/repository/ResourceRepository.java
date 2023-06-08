package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    Resource findByName(String name);
}