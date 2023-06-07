package com.todolist.app.springmvcboottodolist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(NewTaskController.class)
public class NewTaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test of getting new-task page
     * @throws Exception
     */
    @Test
    public void test_getting_new_task_page() throws Exception {
        this.mockMvc.perform(get("/new-task")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test of pushing ADD button
     * @throws Exception
     */
    @Test
    public void test_pushing_add_button() throws Exception {
        this.mockMvc.perform(post("/new-task").param("ADD", "ADD").param("text","Task 1").
                param("date", "2023-10-05").param("status", "INCOMPLETED").
                param("priority", "NORMAL").param("tags", "DAILYROUTINE").
                param("tags", "HOME").param("tags", "READING")).andDo(print())
                .andExpect(status().isFound());
    }

    /**
     * Test of pushing CANCEL button
     * @throws Exception
     */
    @Test
    public void test_pushing_cancel_button() throws Exception {
        this.mockMvc.perform(post("/new-task").param("CANCEL", "CANCEL")).andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("see-all-tasks"));
    }
}
