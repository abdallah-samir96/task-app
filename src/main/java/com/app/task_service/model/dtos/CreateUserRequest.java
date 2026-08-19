package com.app.task_service.model.dtos;


public record CreateUserRequest(
        String name,
        String email,
        String password
) {
}