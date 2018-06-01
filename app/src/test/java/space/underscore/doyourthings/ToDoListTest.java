package space.underscore.doyourthings;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToDoListTest {
    private ToDoList list;
    private ToDoItem activeItem;
    private ToDoItem doneItem;


    @Before
    public void before() {
        this.list = new ToDoList();

        activeItem = new ToDoItem("Get milk", "Semi-skimmed");
        doneItem = new ToDoItem("Find a job", "£40k+");
        doneItem.toggleDone();

        this.list.add(activeItem);
        this.list.add(doneItem);
    }

    @Test
    public void getAll() {
        assertEquals(2, list.getAll().size());
    }

    @Test
    public void getActive() {
        ArrayList<ToDoItem> active = list.getActive();
        assertEquals(1, active.size());
        assertEquals(activeItem, active.get(0));
    }

    @Test
    public void getDone() {
        ArrayList<ToDoItem> done = list.getDone();
        assertEquals(1, done.size());
        assertEquals(doneItem, done.get(0));
    }

    @Test
    public void add() {
        list.add(new ToDoItem("Something", "Who adds notes?"));
        assertEquals(3, list.getAll().size());
    }

    @Test
    public void delete() {
        list.delete(doneItem);
        assertEquals(1, list.getAll().size());
    }
}