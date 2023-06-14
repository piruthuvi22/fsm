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

    private int taskid;

    private String description;

    private int agentid;

    private String customerPhoneNumber;

    private Boolean handled;

}
