package space.underscore.doyourthings;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TagDao {
    @Query("select * from Tag")
    List<Tag> getTags();

    @Insert
    void insert(Tag tag);

    @Update
    void update(Tag tag);

    @Delete
    void delete(Tag tag);
}
