package com.todolist.app.springmvcboottodolist.controllers;


import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.service.Store;
import com.todolist.app.springmvcboottodolist.service.ToDoListStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.Map;


@Controller
@RequestMapping("/see-all-tasks")
public class SeeAllTasksController {
    @Autowired
    private ToDoListStore todo;

    @GetMapping
    public String getSeeAllTasks(Model model){
        Map<String, Item> onhold = todo.getItemsByStatus(Status.INCOMPLETED);
        Map<String, Item> completed = todo.getItemsByStatus(Status.COMPLETED);

        int count = onhold.size();
        model.addAttribute("count", count);
        model.addAttribute("onhold", onhold);
        model.addAttribute("completed", completed);
        return "see-all-tasks";
    }

    @PostMapping
    public String pushAddButton(){
        return "redirect:new-task";
    }

}