package com.todolist.app.springmvcboottodolist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test of getting notification page
     * @throws Exception
     */
    @Test
    public void test_getting_notification_page() throws Exception{
        this.mockMvc.perform(get("/notification").param("operation", "ADD")
                .param("id", UUID.randomUUID().toString())).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test of pushing ADD button
     *  @throws Exception
     */
    @Test
    public void test_pushing_return_button() throws Exception {
        this.mockMvc.perform(post("/notification").param("RETURN", "RETURN")).andDo(print()).
                andExpect(status().isFound()).andExpect(redirectedUrl("see-all-tasks"));
    }
}
