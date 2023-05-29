package com.todolist.app.springmvcboottodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.todolist.app.springmvcboottodolist.*")
public class SpringMvcBootTodoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBootTodoListApplication.class, args);
	}

}
