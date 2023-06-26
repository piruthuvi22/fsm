package com.freshkeys.fsm.entity;

import com.freshkeys.fsm.enums.TaskUpdateEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TaskUpdate")
public class TaskUpdate {
    @Id
    @GeneratedValue
    private int id;
    private int taskId;
    private String data;

    @Enumerated(EnumType.STRING)
    private TaskUpdateEnum type;
    private String date;
}