package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.todolist.app.springmvcboottodolist.models.Status;
import java.util.*;

@Service
public class ToDoListStore implements Store{
    private static final Map<String, Item> items = new LinkedHashMap<>();

    static {
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        items.put(getUuid(), new Item("Task 1", "2023-04-10", Status.INPROGRESS, Priority.NORMAL, tags1));
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        items.put(getUuid(), new Item("Task 2", "2023-04-10", Status.PENDING, Priority.MINOR, tags2));
        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.DAILYROUTINE);
        tags3.add(Tag.HOME);
        tags3.add(Tag.READING);
        items.put(getUuid(), new Item("Task 3", "2023-04-10", Status.COMPLETED, Priority.CRITICAL, tags3));
    }

    public synchronized Map<String, Item> getItems() {
        return items;
    }

    public static synchronized String getUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * This method adds a new task to todo list
     * @param item - it's a task, which must be added
     */
    public synchronized String addItem(Item item){
        String uuid = getUuid();
        items.put(uuid, item);
        return uuid;
    }

    /**
     * This method changes status of task
     * @param id - id of task in the list
     * @param st - it's a new status for task
     */
    public synchronized void changeStatus(String id, Status st){
        Item value = items.get(id);
        value.setStatus(st);
    }

    /**
     * This method changes information about task in the todo list
     * @param id - id of task in the list
     * @param item - changed task in the list
     */
    public synchronized void changeItem(String id, Item item){
        Item value = items.get(id);
        value.setValue(item.getValue());
        value.setDate(item.getDate());
        value.setStatus(item.getStatus());
        value.setPriority(item.getPriority());
        value.setTags(item.getTags());
    }

    /**
     * This method removed a task from todo list
     * @param id - id of task in the list
     */
    public synchronized void removeItem(String id){
        items.remove(id);
    }
}
