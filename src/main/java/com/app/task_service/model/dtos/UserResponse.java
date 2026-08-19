package com.app.task_service.model.dtos;

public record UserResponse(
        Long id,
        String name,
        String email
) {
}