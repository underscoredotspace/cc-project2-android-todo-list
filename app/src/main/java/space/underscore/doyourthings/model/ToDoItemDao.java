package space.underscore.doyourthings.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ToDoItemDao {
    @Query("select * from todoitem")
    List<ToDoItem> getAll();

    @Query("select * from todoitem where done = 0")
    List<ToDoItem> getActive();

    @Query("select * from todoitem  where done = 1")
    List<ToDoItem> getDone();

    @Insert
    void insert(ToDoItem toDoItem);

    @Update
    void update(ToDoItem toDoItem);

    @Delete
    void delete(ToDoItem toDoItem);

    @Insert
    void deleteAll(ToDoItem toDoItem);
}
