package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
