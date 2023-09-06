package com.todolist.app.springmvcboottodolist.controllers;

import com.todolist.app.springmvcboottodolist.models.*;
import com.todolist.app.springmvcboottodolist.service.TaskRepository;
import com.todolist.app.springmvcboottodolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.todolist.app.springmvcboottodolist.service.Store;


@Controller
@RequestMapping("/new-task")
public class NewTaskController {
    @Autowired
    private ToDoListService toDoListService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String getNewTask(){
        return "new-task";
    }

    @PostMapping(params = "ADD")
    public String pushAddButton(@RequestParam("text") String text, @RequestParam("date") String date,
                                @RequestParam("status") Status status, @RequestParam("priority") Priority priority,
                                @RequestParam("tags") List<Tag> tags){
        //Item item = new Item(text, date, status, priority, tags);
        //String id = toDoListService.addItemService(item);
        String id = UUID.randomUUID().toString();
        Task task = new Task(id, text, date, status.toString(), priority.toString(), tags.toString());
        taskRepository.save(task);
        return "redirect:notification?operation=ADD&id=" + id;
    }

    @PostMapping(params = "CANCEL")
    public String pushCancelButton(){
        return "redirect:see-all-tasks";
    }
}
