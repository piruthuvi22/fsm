package com.freshkeys.fsm.ResponseModel;

import com.freshkeys.fsm.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskModel {
    private int id;
    private String title;
    private String description;
    private String date;
    private String address;
    private String phoneNumber;
    private String customerName;
    private TaskStatusEnum status;

    // Constructor, getters, and setters
}
