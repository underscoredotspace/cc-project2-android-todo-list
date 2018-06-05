package space.underscore.doyourthings;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "DoYourThings";

    private AppDb database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.database = Room.databaseBuilder(getApplicationContext(),
                AppDb.class, DATABASE_NAME).fallbackToDestructiveMigration().build();

        INSTANCE = this;
    }

    public AppDb getDB() {
        return this.database;
    }

}
