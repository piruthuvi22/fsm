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
@Table(name = "TaskNotes")
public class TaskNote {
    @Id
    @GeneratedValue
    private int id;

    private int taskId;
    private String message;

    private String date;


}


//enum TaskStatusEnum {
//    PENDING,
//    REJECTED,
//    PROGRESS,
//    COMPLETED
//}