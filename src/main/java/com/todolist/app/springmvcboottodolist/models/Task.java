package com.todolist.app.springmvcboottodolist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    private String id;
    private String value;
    private Status status;
    private Priority priority;
    private String date;
    private List<Tag> tags;

}
