package com.todolist.app.springmvcboottodolist.models;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class Item {
    private String value;
    private Status status;
    private Priority priority;
    private String date;
    private List<Tag> tags;
    public Item(String value, String date, Status status, Priority priority, List<Tag> tags){
        this.value = value;
        this.date = date;
        this.status = status;
        this.priority = priority;
        this.tags = tags;
    }

    public String showTags(){
        String str = "";
        for(Tag t : tags){
            str = str + "#" + t + "  ";
        }
        return str;
    }
}