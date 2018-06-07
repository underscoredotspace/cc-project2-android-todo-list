package space.underscore.doyourthings;

import org.junit.Before;
import org.junit.Test;

import space.underscore.doyourthings.model.ToDoItem;

import static org.junit.Assert.*;

public class ToDoItemTest {
    private ToDoItem todo;

    @Before
    public void before() {
        todo = new ToDoItem("Get milk", "Semi-skimmed");
    }

    @Test
    public void getStatus() {
        assertEquals(false, todo.isDone());
    }

    @Test
    public void toggleStatus() {
        todo.toggleDone();
        assertEquals(true, todo.isDone());
    }

    @Test
    public void getTitle() {
        assertEquals("Get milk", todo.getTitle());
    }

    @Test
    public void setTitle() {
        todo.setTitle("Something");
        assertEquals("Something", todo.getTitle());
    }

    @Test
    public void getNotes() {
        assertEquals("Semi-skimmed", todo.getNotes());
    }

    @Test
    public void setNotes() {
        todo.setNotes("Full lactose-free");
        assertEquals("Full lactose-free", todo.getNotes());
    }
}