package com.freshkeys.fsm.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskWithCustomerName {
    private int id;
    private String title;
    private String description;
    private String date;
    private String address;

    private String customerName;

    // Constructor, getters, and setters
}
