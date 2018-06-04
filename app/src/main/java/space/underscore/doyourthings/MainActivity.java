package space.underscore.doyourthings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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
                App app = App.get();
                AppDb db = app.getDB();
                ToDoItemDao todo = db.toDoItemDao();
                List<ToDoItem> todos = todo.getAll();

                fillListView(todos);
            }
        }).start();

    }

    private void fillListView(final List<ToDoItem> todos) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TodoListAdapter todoListAdapter = new TodoListAdapter(getBaseContext(), todos);
                todoListView.setAdapter(todoListAdapter);
            }
        });
    }

    public void onFabClick(View view) {
        Intent intent = new Intent(this, TodoItemDetail.class);
        startActivity(intent);
    }

}
