package space.underscore.doyourthings;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDoItem> list = new ArrayList<>();

    ToDoList() {
        this.add(new ToDoItem("Get Milk", "Semi-skimmed"));
    }

    public void add(ToDoItem todo) {
        this.list.add(todo);
    }

    public void delete(ToDoItem todo) {
        this.list.remove(todo);
    }

    public ArrayList<ToDoItem> getAll() {
        return new ArrayList<>(this.list);
    }

    public ArrayList<ToDoItem> getActive() {
        ArrayList<ToDoItem> active = new ArrayList<>();

        for (ToDoItem item : this.list) {
            if (!item.isDone()) {
                active.add(item);
            }
        }

        return active;
    }

    public ArrayList<ToDoItem> getDone() {
        ArrayList<ToDoItem> done = new ArrayList<>();

        for (ToDoItem item : this.list) {
            if (item.isDone()) {
                done.add(item);
            }
        }

        return done;
    }
}
