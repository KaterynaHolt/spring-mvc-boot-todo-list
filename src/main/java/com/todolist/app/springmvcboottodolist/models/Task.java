package com.todolist.app.springmvcboottodolist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
//@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    private String id;
    private String value;
    private String date;
    private String status;
    private String priority;
    private String tag;

    public Task(String id, String value, String date, String status, String priority, String tag){
        this.id = id;
        this.value = value;
        this.date = date;
        this.status = status;
        this.priority = priority;
        this.tag = tag;
    }

    public Task() {

    }
}
