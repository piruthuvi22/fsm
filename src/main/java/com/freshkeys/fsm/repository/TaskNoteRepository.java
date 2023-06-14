package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.TaskNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TaskNoteRepository extends JpaRepository<TaskNote, Integer> {

     List<TaskNote> findAllByTaskId(int taskId);

}

