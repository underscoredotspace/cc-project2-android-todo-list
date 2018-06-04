package space.underscore.doyourthings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView todoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = findViewById(R.id.todoListView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                List todos = App.get().getDB().toDoItemDao().getAll();
                populateList(todos);
            }
        });
    }

    void populateList(final List todos) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TodoListAdapter todoListAdapter = new TodoListAdapter(getBaseContext(), todos);
                todoListView.setAdapter(todoListAdapter);
            }
        });
    }

//    private void populateAlbums(final List<Album> albums) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                AlbumAdapter albumAdapter = new AlbumAdapter(getBaseContext(), albums);
//                albumListView.setAdapter(albumAdapter);
//            }
//        });
//    }

    public void onListItemClick(View todoItem) {
        ToDoItem todo = (ToDoItem) todoItem.getTag();
    }

}
