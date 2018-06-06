package space.underscore.doyourthings;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ToDoItem.class, Tag.class}, version = 4)
public abstract class AppDb extends RoomDatabase {
    public abstract ToDoItemDao toDoItemDao();
    public abstract TagDao tagDao();
}
