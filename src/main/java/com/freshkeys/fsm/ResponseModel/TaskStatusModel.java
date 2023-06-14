package com.freshkeys.fsm.ResponseModel;

import com.freshkeys.fsm.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class TaskStatusModel {
    private int id;
    private String message;
    private TaskStatusEnum status;

    // Constructor, getters, and setters
}
