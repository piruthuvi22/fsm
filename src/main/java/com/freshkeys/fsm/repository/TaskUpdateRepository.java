package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.TaskUpdate;
import com.freshkeys.fsm.enums.TaskUpdateEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TaskUpdateRepository extends JpaRepository<TaskUpdate, Integer> {

    List<TaskUpdate> findAllByTaskId(int taskId);

    List<TaskUpdate> findAllByTaskIdAndType(int taskId, TaskUpdateEnum type);

}

