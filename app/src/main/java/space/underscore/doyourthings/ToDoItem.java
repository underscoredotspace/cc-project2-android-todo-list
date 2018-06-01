package space.underscore.doyourthings;

public class ToDoItem {
    private String title;
    private String notes;
    private boolean status = false;


    public ToDoItem(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void toggleStatus() {
        this.status = !this.status;
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
