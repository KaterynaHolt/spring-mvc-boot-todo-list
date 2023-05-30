package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Status;


public interface Store {
    /**
     * This method adds a new task to todo list
     * @param item - it's a task, which must be added
     */
    String addItem(Item item);

    /**
     * This method changes status of task
     * @param id - it's an id of task in map
     * @param st - it's a new status for task
     */
    void changeStatus(String id, Status st);

    /**
     * This method changes information about task in the todo list
     * @param id - id of task in the list
     * @param item - changed task in the list
     */
    void changeItem(String id, Item item);

    /**
     * This method removed a task from todo list
     * @param id - id of task in the list
     */
    void removeItem(String id);
}
