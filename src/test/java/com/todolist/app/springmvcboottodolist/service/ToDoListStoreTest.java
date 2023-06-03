package com.todolist.app.springmvcboottodolist.service;


import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;


@WebMvcTest(ToDoListStore.class)
public class ToDoListStoreTest {
    @Autowired
    private ToDoListStore todo;

    /**
     * Test getting items by status - getItemsByStatus
     */
    @Test
    public void test_getting_items_by_status(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.DAILYROUTINE);
        tags3.add(Tag.HOME);
        tags3.add(Tag.READING);
        //WHEN
        Map<String, Item> onhold = todo.getItemsByStatus(Status.INCOMPLETED);
        Map<String, Item> completed = todo.getItemsByStatus(Status.COMPLETED);
        //THEN
        Assertions.assertTrue(onhold.size() == 2);
        Assertions.assertTrue(completed.size() == 1);
        assertThat(onhold.values()).extracting(Item::getStatus).contains(Status.PENDING);
        assertThat(onhold.values()).extracting(Item::getValue).contains("Task 2");
        assertThat(onhold.values()).extracting(Item::getDate).contains("2023-04-10");
        assertThat(onhold.values()).extracting(Item::getPriority).contains(Priority.MINOR);
        assertThat(onhold.values()).extracting(Item::getTags).contains(tags1);

        assertThat(onhold.values()).extracting(Item::getStatus).contains(Status.INPROGRESS);
        assertThat(onhold.values()).extracting(Item::getValue).contains("Task 1");
        assertThat(onhold.values()).extracting(Item::getDate).contains("2023-04-10");
        assertThat(onhold.values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(onhold.values()).extracting(Item::getTags).contains(tags2);

        assertThat(completed.values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(completed.values()).extracting(Item::getValue).contains("Task 3");
        assertThat(completed.values()).extracting(Item::getDate).contains("2023-04-10");
        assertThat(completed.values()).extracting(Item::getPriority).contains(Priority.CRITICAL);
        assertThat(completed.values()).extracting(Item::getTags).contains(tags3);
    }
}
