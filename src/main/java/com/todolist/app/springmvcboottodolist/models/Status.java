package com.todolist.app.springmvcboottodolist.models;

/**
 * These are statuses, which user can mark his tasks
 */
public enum Status {
    /**
     * This status means that the task is done
     */
    COMPLETED,
    /**
     * This status means that the task hasn't been done yet
     */
    INCOMPLETED,
    /**
     * This status means that the task is being worked
     */
    INPROGRESS,
    /**
     * This status means that the task is in a queue
     */
    PENDING;

    @Override
    public String toString() {
        String str = name().toLowerCase().substring(0, 1).toUpperCase() + name().toLowerCase().substring(1);
        return str;
    }
}