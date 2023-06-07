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
@Table(name = "Supervisors")

public class Supervisor {
    @Id
    @GeneratedValue
    private String id;

    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
}
