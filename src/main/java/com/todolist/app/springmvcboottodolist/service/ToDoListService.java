package com.todolist.app.springmvcboottodolist.service;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ToDoListService {
    @Autowired
    private ToDoListStore toDoListStore;

    @Autowired
    private Store store;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * This method choose operation, which must be done
     * @param operation - title of operation
     * @param id - id of item
     */
    public void chooseOperation(String operation, String id){
        switch (operation) {
            case "COMPLETE" :
                //toDoListStore.changeStatus(id, Status.COMPLETED);
                taskRepository.changeStatusForCompleted(id);

                break;
            case "INCOMPLETE" :
                //toDoListStore.changeStatus(id, Status.INCOMPLETED);
                taskRepository.changeStatusForIncompleted(id);
                break;
            case "REMOVE" :
                //toDoListStore.removeItem(id);
                taskRepository.deleteById(id);
                break;
        }
    }

    /**
     * This method gets item by id
     * @param id - id of Item
     * @return result - map of id and Item
     */
    public Optional<Map.Entry<String, Item>> getItemById(String id){
        Optional<Map.Entry<String, Item>> result = toDoListStore.getItems().entrySet().stream().filter(val -> val.getKey().
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
            for(Map.Entry<String, Item> entry : toDoListStore.getItems().entrySet()){
                if(entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        else{
            for(Map.Entry<String, Item> entry : toDoListStore.getItems().entrySet()){
                if(!entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }

    public void changeItemService(String uuid, Item item){
        store.changeItem(uuid, item);
    }

    public String addItemService(Item item){
        return store.addItem(item);
    }
}
