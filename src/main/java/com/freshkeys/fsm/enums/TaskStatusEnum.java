package com.freshkeys.fsm.enums;

import org.springframework.stereotype.Component;

public enum TaskStatusEnum {
    PENDING, // First time task created
    ASSIGNED,// Task assigned to agent
    PROGRESS, // Task accepted by agent & work in progress
    REJECTED, // Task rejected by agent
    COMPLETED // Task completed by agent
}
