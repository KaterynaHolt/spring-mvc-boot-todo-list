package com.todolist.app.springmvcboottodolist.models;

public enum Priority {
    MINOR,
    CRITICAL,
    NORMAL;

    @Override
    public String toString() {
        String str = name().toLowerCase().substring(0, 1).toUpperCase() + name().toLowerCase().substring(1);
        return str;
    }
}