package com.app.task_service.resources;

import com.app.task_service.model.dtos.TaskRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Value("${DATA_BASE.URL}")
    private String url;


    @GetMapping
    public ResponseEntity<List<String>> getAllTasks() {
        System.out.printf("The database url: %s", url);
        return ResponseEntity.ok(
                List.of("Write feature", "write tests", "generate reports")
        );
    }

    @PostMapping
    public void add(@RequestBody TaskRequestDTO task){
        System.out.printf("Task %s has been added", task);
    }

    @DeleteMapping
    public void delete(@RequestParam String name) {
        System.out.printf("trying to delete task %s", name);
    }

}
