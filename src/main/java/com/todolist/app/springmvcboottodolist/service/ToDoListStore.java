package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.todolist.app.springmvcboottodolist.models.Status;
import java.util.*;


@Service
public class ToDoListStore implements Store{
    private final Map<String, Item> items = new LinkedHashMap<>();

    /**
     * This method adds some tasks at the beginning
     */
    @PostConstruct
    private void init(){
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

    /**
     * This method choose operation, which must be done
     * @param operation - title of operation
     * @param id - id of item
     */
    public void chooseOperation(String operation, String id){
        if(operation.equals("COMPLETE")){
            changeStatus(id, Status.COMPLETED);
        }
        else if(operation.equals("INCOMPLETE")){
            changeStatus(id, Status.INCOMPLETED);
        }
        else if(operation.equals("REMOVE")){
            removeItem(id);
        }
    }

    /**
     * This method gets item by id
     * @param id - id of Item
     * @return result - map of id and Item
     */
    public Optional<Map.Entry<String, Item>> getItemById(String id){
        Optional<Map.Entry<String, Item>> result = items.entrySet().stream().filter(val -> val.getKey().
                equals(id)).findFirst();
        return result;
    }

    /**
     * This method gets items to map by their Status
     * @param status - status for choosing
     * @return map with items, which are completed or not
     */
    public Map<String, Item> getItemsByStatus(Status status){
        Map<String, Item> result = new LinkedHashMap<>();
        if(status.equals(Status.COMPLETED)){
            for(Map.Entry<String, Item> entry : getItems().entrySet()){
                if(entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        else{
            for(Map.Entry<String, Item> entry : getItems().entrySet()){
                if(!entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }


    public synchronized Map<String, Item> getItems() {
        return items;
    }

    public synchronized String getUuid() {
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
