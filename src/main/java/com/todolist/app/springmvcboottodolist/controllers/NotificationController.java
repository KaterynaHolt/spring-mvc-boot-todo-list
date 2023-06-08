package com.todolist.app.springmvcboottodolist.controllers;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.service.Store;
import com.todolist.app.springmvcboottodolist.service.ToDoListService;
import com.todolist.app.springmvcboottodolist.service.ToDoListStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private ToDoListService toDoListService;

    @GetMapping
    public String getNotification(@RequestParam String operation, @RequestParam String id, Model model){
        toDoListService.chooseOperation(operation, id);
        Optional<Map.Entry<String, Item>> result = toDoListService.getItemById(id);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        return "notification";
    }

    @PostMapping(params = "RETURN")
    public String pushReturnButton(){
        return "redirect:see-all-tasks";
    }

}
