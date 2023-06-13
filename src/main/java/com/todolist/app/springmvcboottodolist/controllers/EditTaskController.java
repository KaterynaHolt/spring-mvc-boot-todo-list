package com.todolist.app.springmvcboottodolist.controllers;

import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import com.todolist.app.springmvcboottodolist.service.Store;
import com.todolist.app.springmvcboottodolist.service.ToDoListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;


@Controller
@RequestMapping("/edit-task")
public class EditTaskController {
    @Autowired
    private ToDoListService toDoListService;

    @GetMapping
    public String getEditTask(Model model, HttpServletRequest request){
        String uuid = request.getParameter("id");
        model.addAttribute("item", toDoListService.getItemById(uuid));
        model.addAttribute("uuid", uuid);
        return "edit-task";
    }

    @PostMapping(params = "EDIT")
    public String pushEditButton(@RequestParam("text") String text, @RequestParam("date") String date,
                                 @RequestParam("status") Status status, @RequestParam("priority") Priority priority,
                                 @RequestParam("tags") List<Tag> tags, @RequestParam("uuid") String uuid){
        Item item = new Item(text, date, status, priority, tags);
        toDoListService.changeItemService(uuid, item);
        return "redirect:notification?operation=EDIT&id=" + uuid;
    }

    @PostMapping(params = "CANCEL")
    public String pushCancelButton(){
        return "redirect:see-all-tasks";
    }
}
