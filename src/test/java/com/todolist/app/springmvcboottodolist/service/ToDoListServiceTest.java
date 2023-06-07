package com.todolist.app.springmvcboottodolist.service;


import com.todolist.app.springmvcboottodolist.models.Item;
import com.todolist.app.springmvcboottodolist.models.Priority;
import com.todolist.app.springmvcboottodolist.models.Status;
import com.todolist.app.springmvcboottodolist.models.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import java.util.*;
import static org.assertj.core.api.Assertions.*;


@WebMvcTest(ToDoListService.class)
public class ToDoListServiceTest {
    @Autowired
    private ToDoListService todo;

    @Autowired
    private ToDoListStore store;

    /**
     * Test of getting items by Status - getItemsByStatus
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

    /**
     * Test of choosing operation - chooseOperation
     */
    @Test
    public void test_choosing_operation(){
        //GIVEN
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.READING);
        String id = store.addItem(new Item("Task", "2023-06-10", Status.INPROGRESS, Priority.NORMAL, tags));
        String id2 = store.addItem(new Item("Task 2", "2023-06-01", Status.COMPLETED, Priority.MINOR, tags));
        String id3 = store.addItem(new Item("Task 3", "2023-06-02", Status.PENDING, Priority.CRITICAL, tags));
        //WHEN
        todo.chooseOperation("COMPLETE", id);
        todo.chooseOperation("INCOMPLETE", id2);
        int size = store.getItems().size();
        todo.chooseOperation("REMOVE", id3);
        //THEN
        Assertions.assertTrue(store.getItems().size() == size - 1);

        assertThat(store.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(store.getItems().values()).extracting(Item::getValue).contains("Task");
        assertThat(store.getItems().values()).extracting(Item::getDate).contains("2023-06-10");
        assertThat(store.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(store.getItems().values()).extracting(Item::getTags).contains(tags);

        assertThat(store.getItems().values()).extracting(Item::getStatus).contains(Status.INCOMPLETED);
        assertThat(store.getItems().values()).extracting(Item::getValue).contains("Task 2");
        assertThat(store.getItems().values()).extracting(Item::getDate).contains("2023-06-01");
        assertThat(store.getItems().values()).extracting(Item::getPriority).contains(Priority.MINOR);
        assertThat(store.getItems().values()).extracting(Item::getTags).contains(tags);
    }

    /**
     * Test of getting items by id - getItemById
     */
    @Test
    public void test_getting_item_by_id(){
        //GIVEN
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.HOME);
        String id = store.addItem(new Item("Task 1", "2023-06-11", Status.INPROGRESS, Priority.NORMAL, tags));
        //WHEN
        Optional<Map.Entry<String, Item>> result = todo.getItemById(id);
        int size = result.stream().toArray().length;
        //THEN
        Assertions.assertTrue( size == 1);

        assertThat(result.get().getValue().getStatus().equals(Status.INPROGRESS));
        assertThat(result.get().getValue().getValue().equals("Task 1"));
        assertThat(result.get().getValue().getDate().equals("2023-06-11"));
        assertThat(result.get().getValue().getPriority().equals(Priority.NORMAL));
        assertThat(result.get().getValue().getTags().equals(tags));
    }
}
