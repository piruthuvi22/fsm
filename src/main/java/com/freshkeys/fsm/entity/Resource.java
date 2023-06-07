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
@Table(name = "Resources")

public class Resource {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private int quantity;
}
