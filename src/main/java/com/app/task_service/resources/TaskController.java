package com.app.task_service.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {


    @GetMapping
    public ResponseEntity<List<String>> getAllTasks() {

        return ResponseEntity.ok(
                List.of("Write feature", "write tests", "generate reports")
        );
    }
}
