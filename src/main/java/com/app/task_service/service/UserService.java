package com.app.task_service.service;

import com.app.task_service.model.dtos.CreateUserRequest;
import com.app.task_service.model.dtos.UpdateUserRequest;
import com.app.task_service.model.dtos.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, UserResponse> users = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);

    public UserResponse createUser(CreateUserRequest request) {

        Long id = idGenerator.incrementAndGet();

        UserResponse user = new UserResponse(
                id,
                request.name(),
                request.email()
        );

        users.put(id, user);

        return user;
    }

    public List<UserResponse> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public UserResponse getUserById(Long id) {
        return users.get(id);
    }

    public UserResponse updateUser(
            Long id,
            UpdateUserRequest request
    ) {

        UserResponse existingUser = users.get(id);

        if (existingUser == null) {
            return null;
        }

        UserResponse updatedUser = new UserResponse(
                id,
                request.name(),
                request.email()
        );

        users.put(id, updatedUser);

        return updatedUser;
    }

    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
}