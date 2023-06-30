package com.todolist.app.springmvcboottodolist.models;

public enum Tag {
    DAILYROUTINE("Daily routine"),
    HOME("Home"),
    WORK("Work"),
    READING("Reading");

    private final String name;

    Tag(String tag) {
        this.name = tag;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
