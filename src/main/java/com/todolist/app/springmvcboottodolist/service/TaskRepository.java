package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, String> {
    @Query(value = "SELECT t.id, t.value, t.date, t.status, t.priority, t.tag FROM task t WHERE t.status='Completed'", nativeQuery = true)
    List<Task> findCompletedTasks();

    @Query(value = "SELECT t.id, t.value, t.date, t.status, t.priority, t.tag FROM task t WHERE NOT t.status='Completed'", nativeQuery = true)
    List<Task> findIncompletedTasks();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE task t SET t.status = 'Completed' WHERE t.id = :id", nativeQuery = true)
    void changeStatusForCompleted(@Param("id") String id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE task t SET t.status = 'Incompleted' WHERE t.id = :id", nativeQuery = true)
    void changeStatusForIncompleted(@Param("id") String id);
}
