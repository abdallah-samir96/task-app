package com.app.task_service.model.dtos;

import java.time.LocalDateTime;

public record TaskRequestDTO(
        String name,
        LocalDateTime timestamp,
        String assignedUser
) {
}
