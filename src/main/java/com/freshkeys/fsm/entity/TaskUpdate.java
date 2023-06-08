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

    private int task_id;
    private String title;
    private Date date;


}



