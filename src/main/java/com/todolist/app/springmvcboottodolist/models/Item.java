package com.todolist.app.springmvcboottodolist.models;

import java.util.ArrayList;
import java.util.List;


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

    public Item(String value, Status status){
        this.value = value;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTags(List<Tag> tags){
        this.tags.clear();
        for(Tag t : tags){
            this.tags.add(t);
        }
    }

    public String showTags(){
        String str = "";
        for(Tag t : tags){
            str = str + "#" + t + "  ";
        }
        return str;
    }

    @Override
    public String toString(){
        return value + ", " + date + ", " + status + ", " + priority + ", "
                + tags.toString();
    }
}