package com.todolist.app.springmvcboottodolist.controllers;


import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.service.ToDoListStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class SeeAllTasksController {
    @Autowired
    ToDoListStore store;

    @RequestMapping(value="/see-all-tasks",method = RequestMethod.GET)
    public String getSeeAllTasks(Model model){
        Map<String, Item> onhold = new LinkedHashMap<>();
        Map<String, Item> completed = new LinkedHashMap<>();
        for(Map.Entry<String, Item> entry : store.getItems().entrySet()){
            if(!entry.getValue().getStatus().equals(Status.COMPLETED)){
                onhold.put(entry.getKey(), entry.getValue());
            }
            else {
                completed.put(entry.getKey(), entry.getValue());
            }
        }
        int count = onhold.size();
        model.addAttribute("count", count);
        model.addAttribute("onhold", onhold);
        model.addAttribute("completed", completed);
        return "see-all-tasks";
    }

    @RequestMapping(value = "/see-all-tasks", method = RequestMethod.POST)
    public String pushAddButton(){
        //return "redirect:new-task";
        return "new-task";
    }

}
