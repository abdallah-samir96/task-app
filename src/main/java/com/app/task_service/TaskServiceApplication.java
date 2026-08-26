package com.app.task_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
		var envs = System.getenv();
		// printing all env variables provided inside the container
		envs.forEach((key, value) -> System.out.printf("%s = %s %n ", key, value));


	}

}
