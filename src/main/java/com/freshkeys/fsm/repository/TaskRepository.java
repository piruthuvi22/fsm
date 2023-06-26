package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.ResponseModel.TaskModel;
import com.freshkeys.fsm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,c.phonenumber, c.firstname || ' ' || c.lastname,t.status) " + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber")
    List<TaskModel> findTasksWithCustomerName();

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,t.customerPhoneNumber, c.firstname || ' ' || c.lastname, t.status)" + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber WHERE t.agentId = :agentId")
    List<?> getAllTasksOfAgent(@Param("agentId") int agentId);

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,c.phonenumber, c.firstname || ' ' || c.lastname, t.status)" + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber WHERE t.agentId = :agentId AND t.status = 'PROGRESS'")
    List<TaskModel> getProgressedTasksOfAgent(@Param("agentId") int agentId);

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,c.phonenumber, c.firstname || ' ' || c.lastname, t.status)" + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber WHERE t.agentId = :agentId AND t.status = 'ASSIGNED'")
    List<TaskModel> getAssignedTasksOfAgent(@Param("agentId") int agentId);

    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,c.phonenumber, c.firstname || ' ' || c.lastname, t.status)" + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber WHERE t.agentId = :agentId AND t.status = 'COMPLETED'")
    List<TaskModel> getCompletedTasksOfAgent(@Param("agentId") int agentId);


    @Query("SELECT new com.freshkeys.fsm.ResponseModel.TaskModel(t.id, t.title, t.description, t.date, t.address,c.phonenumber, c.firstname || ' ' || c.lastname, t.status)" + "FROM Task t JOIN Customer c ON t.customerPhoneNumber = c.phonenumber WHERE t.agentId = :agentId")
    List<TaskModel> getTasksOfAgent(@Param("agentId") int agentId);

    List<TaskModel> findByAgentId(int agentId);

    Task findByCustomerPhoneNumber(String phoneNumber);
}


//@Repository
//public interface TaskRepository extends JpaRepository<Task, Integer> {
//    @Query("SELECT t, c.firstname, c.lastname FROM Task t INNER JOIN Customer c ON t.customer_id = c.id")
//    List<Object[]> findTasksWithCustomerName();
//}
