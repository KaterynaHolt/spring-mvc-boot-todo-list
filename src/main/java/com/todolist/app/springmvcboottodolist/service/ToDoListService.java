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
    private ToDoListStore td;

    /**
     * This method choose operation, which must be done
     * @param operation - title of operation
     * @param id - id of item
     */
    public void chooseOperation(String operation, String id){
        if(operation.equals("COMPLETE")){
            td.changeStatus(id, Status.COMPLETED);
        }
        else if(operation.equals("INCOMPLETE")){
            td.changeStatus(id, Status.INCOMPLETED);
        }
        else if(operation.equals("REMOVE")){
            td.removeItem(id);
        }
    }

    /**
     * This method gets item by id
     * @param id - id of Item
     * @return result - map of id and Item
     */
    public Optional<Map.Entry<String, Item>> getItemById(String id){
        Optional<Map.Entry<String, Item>> result = td.getItems().entrySet().stream().filter(val -> val.getKey().
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
            for(Map.Entry<String, Item> entry : td.getItems().entrySet()){
                if(entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        else{
            for(Map.Entry<String, Item> entry : td.getItems().entrySet()){
                if(!entry.getValue().getStatus().equals(Status.COMPLETED)){
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }
}
