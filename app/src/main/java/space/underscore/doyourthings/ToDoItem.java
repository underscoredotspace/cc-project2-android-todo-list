package space.underscore.doyourthings;

import java.io.Serializable;

public class ToDoItem{
    private String title;
    private String notes;
    private boolean done = false;


    public ToDoItem(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }

    public boolean isDone() {
        return this.done;
    }

    public void toggleDone() {
        this.done = !this.done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
