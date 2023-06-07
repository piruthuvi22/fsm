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
@Table(name = "Customers")

public class Customer {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;
    private String email;

    private String phoneNumber;

    private String  Address;
}
