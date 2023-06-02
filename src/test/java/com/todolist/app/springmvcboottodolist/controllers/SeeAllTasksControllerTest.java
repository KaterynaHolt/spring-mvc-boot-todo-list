package com.todolist.app.springmvcboottodolist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SeeAllTasksController.class)
public class SeeAllTasksControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test of getting see-all-tasks page
     * @throws Exception
     */
    @Test
    public void test_getting_see_all_tasks_page() throws Exception {
        this.mockMvc.perform(get("/see-all-tasks")).andDo(print()).andExpect(status().isOk());
    }

}
