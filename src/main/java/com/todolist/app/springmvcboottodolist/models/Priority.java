package com.todolist.app.springmvcboottodolist.models;

public enum Priority {
    MINOR("Minor"),
    CRITICAL("Critical"),
    NORMAL("Normal");

    private final String name;

    Priority(String priority) {
        this.name = priority;
    }

    @Override
    public String toString() {
        return this.name;
    }
}