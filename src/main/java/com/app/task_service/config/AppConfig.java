package com.app.task_service.config;

import com.app.task_service.model.dtos.AppProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final AppProperties properties;

    public AppConfig(AppProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void printProperties(){
         System.out.printf("properties: %s %n", properties);
    }

}
