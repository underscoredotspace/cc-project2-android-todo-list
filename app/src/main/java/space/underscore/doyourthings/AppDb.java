package space.underscore.doyourthings;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import space.underscore.doyourthings.model.ToDoItem;
import space.underscore.doyourthings.model.ToDoItemDao;

@Database(entities = {ToDoItem.class}, version = 5)
public abstract class AppDb extends RoomDatabase {
    public abstract ToDoItemDao toDoItemDao();
}
