package com.app.task_service.model.dtos;

public record UpdateUserRequest(
        String name,
        String email
) {
}