package com.todolist.app.springmvcboottodolist.models;

/**
 * These are statuses, which user can mark his tasks
 */
public enum Status {
    /**
     * This status means that the task is done
     */
    COMPLETED("Completed"),
    /**
     * This status means that the task hasn't been done yet
     */
    INCOMPLETED("Incompleted"),
    /**
     * This status means that the task is being worked
     */
    INPROGRESS("In progress"),
    /**
     * This status means that the task is in a queue
     */
    PENDING("Penging");

    private final String name;

    Status(String status) {
        this.name = status;
    }

    @Override
    public String toString() {
        return this.name;
    }
}