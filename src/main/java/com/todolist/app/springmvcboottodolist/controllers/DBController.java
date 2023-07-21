package com.todolist.app.springmvcboottodolist.controllers;

import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import com.todolist.app.springmvcboottodolist.models.Task;
import com.todolist.app.springmvcboottodolist.service.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.UUID;

@Controller
public class DBController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JdbcTemplate jdbc;

    /*@PostMapping(path="/add")
    public @ResponseBody String addNewTask (@RequestParam("text") String text, @RequestParam("date") String date,
                                            @RequestParam("status") Status status, @RequestParam("priority") Priority priority,
                                            @RequestParam("tags") List<Tag> tags) {
        Task t = new Task();
        t.setId(UUID.randomUUID().toString());
        t.setValue(text);
        t.setDate(date);
        t.setStatus(status);
        t.setPriority(priority);
        t.setTags(tags);
        taskRepository.save(t);
        return "Saved";
    }*/

    /*@GetMapping("/tasks")
    public String listAll(Model model) {
        List<Task> listTasks = (List<Task>) taskRepository.findAll();
        model.addAttribute("listTasks", listTasks);
        return "tasks";
    }*/

    @RequestMapping("/insert")
    public String index(){
        String id = UUID.randomUUID().toString();
        jdbc.execute("insert into tasks(idTask, value, status, priority, tags)" +
                "values(id, 'Task 1', '2023-04-10', 'INPROGRESS', 'NORMAL', 'WORK, READING')");
        return"data inserted Successfully";
    }
}
