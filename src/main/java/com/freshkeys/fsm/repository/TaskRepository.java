package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.ResponseModel.TaskWithCustomerName;
import com.freshkeys.fsm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskWithCustomerName(t.id, t.title, t.description, t.date, t.address, c.firstname || ' ' || c.lastname) " + "FROM Task t JOIN Customer c ON t.customerId = c.id")
    List<TaskWithCustomerName> findTasksWithCustomerName();

    List<Task> findByAgentId(int agentId);


}


//@Repository
//public interface TaskRepository extends JpaRepository<Task, Integer> {
//    @Query("SELECT t, c.firstname, c.lastname FROM Task t INNER JOIN Customer c ON t.customer_id = c.id")
//    List<Object[]> findTasksWithCustomerName();
//}
