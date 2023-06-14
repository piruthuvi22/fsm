package com.freshkeys.fsm.entity;

import com.freshkeys.fsm.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String customerPhoneNumber;

    @Column(columnDefinition = "integer default 0")
    private int agentId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String date;
    private String address;

    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

}

