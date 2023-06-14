package com.freshkeys.fsm.entity;

import jakarta.persistence.*;
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

@Column(unique = true)
    private String phonenumber;

    private String firstname;

    private String lastname;
    private String email;



    private String  address;
}