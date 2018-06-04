package space.underscore.doyourthings;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ToDoItem  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
