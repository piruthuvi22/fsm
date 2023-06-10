package com.freshkeys.fsm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TaskUpdates")
public class TaskUpdate {
    @Id
    @GeneratedValue
    private int id;

    private int taskId;
    private String message;
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;
    private Date date;


}


enum TaskStatusEnum {
    PENDING,
    REJECTED,
    PROGRESS,
    COMPLETED
}