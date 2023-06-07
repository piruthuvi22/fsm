package com.freshkeys.fsm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Complaints")
public class Complaint {
    @Id
    @GeneratedValue

    private int id;

    private String taskId;

    private String taskTitle;


    private String agentName;

    private String customerName;

    private String description;
}
