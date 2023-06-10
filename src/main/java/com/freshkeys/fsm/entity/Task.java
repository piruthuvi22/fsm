package com.freshkeys.fsm.entity;

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
    private int customerId;

    @Column(columnDefinition = "integer default null")
    private int agentId;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String date;
    private String address;

}
