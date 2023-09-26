package com.github.alekseypetkun.t1_task;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "T1TaskApplication",
        description = "Тестовое задание от Т1 Консалтинг"
))
public class T1TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(T1TaskApplication.class, args);
    }

}
