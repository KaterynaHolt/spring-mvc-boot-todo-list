package com.todolist.app.springmvcboottodolist.controllers;


import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import com.todolist.app.springmvcboottodolist.service.Store;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EditTaskController.class)
public class EditTaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Store store;

    /**
     * Test of getting edit-task page
     * @throws Exception
     */
    @Test
    public void test_getting_edit_task_page() throws Exception {
        this.mockMvc.perform(get("/edit-task")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test of pushing EDIT button
     * @throws Exception
     */
    @Test
    public void test_pushing_edit_button() throws Exception {
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        String uuid = store.addItem(new Item("Task 1", "2023-04-10", Status.INPROGRESS, Priority.NORMAL, tags1));
        this.mockMvc.perform(post("/edit-task").param("EDIT", "EDIT").param("text", "Test")
                .param("date", "2023-06-07").param("status", "INPROGRESS")
                .param("priority", "MINOR").param("tags", "READING")
                .param("uuid", uuid)).andDo(print()).andExpect(status().isFound());
    }

    /**
     * Test of pushing CANCEL button
     * @throws Exception
     */
    @Test
    public void test_pushing_cancel_button() throws Exception {
        this.mockMvc.perform(post("/edit-task").param("CANCEL", "CANCEL")).andDo(print()).
                andExpect(status().isFound()).andExpect(redirectedUrl("see-all-tasks"));
    }
}
