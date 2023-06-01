package com.todolist.app.springmvcboottodolist.controllers;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.todolist.app.springmvcboottodolist.service.Store;


@Controller
@RequestMapping("/new-task")
public class NewTaskController {
    @Autowired
    private Store store;

    @GetMapping
    public String getNewTask(){
        return "new-task";
    }

    @PostMapping(params = "ADD")
    public String pushAddButton(@RequestParam("text") String text, @RequestParam("date") String date,
                                @RequestParam("status") Status status, @RequestParam("priority") Priority priority,
                                @RequestParam("tags") List<Tag> tags){
        Item item = new Item(text, date, status, priority, tags);
        String id = store.addItem(item);
        System.out.println("New task " + id + " was added!");
        //return "redirect:notification";
        return "notification";
    }

    @PostMapping(params = "CANCEL")
    public String pushCancelButton(){
        return "redirect:see-all-tasks";
    }
}
