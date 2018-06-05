package space.underscore.doyourthings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView todoListView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

            switch (item.getItemId()) {
                case R.id.navigation_all:
                    sharedPreferences.edit().putInt("nav", R.id.navigation_all).apply();
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

                    return true;
                case R.id.navigation_todo:
                    sharedPreferences.edit().putInt("nav", R.id.navigation_todo).apply();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            App app = App.get();
                            AppDb db = app.getDB();
                            ToDoItemDao todo = db.toDoItemDao();
                            List<ToDoItem> todos = todo.getActive();

                            fillListView(todos);
                        }
                    }).start();

                    return true;
                case R.id.navigation_done:
                    sharedPreferences.edit().putInt("nav", R.id.navigation_done).apply();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            App app = App.get();
                            AppDb db = app.getDB();
                            ToDoItemDao todo = db.toDoItemDao();
                            List<ToDoItem> todos = todo.getDone();

                            fillListView(todos);
                        }
                    }).start();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = findViewById(R.id.todoListView);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        navigation.setSelectedItemId(sharedPreferences.getInt("nav", R.id.navigation_all));
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

    public void onCheckBoxClicked(View view) {
        final ToDoItem toDoItem = (ToDoItem) view.getTag();
        toDoItem.toggleDone();

        new Thread(new Runnable() {
            @Override
            public void run() {
            App app = App.get();
            AppDb db = app.getDB();
            ToDoItemDao todo = db.toDoItemDao();
            todo.update(toDoItem);
            }
        }).start();
    }

    public void onListItemClicked(View view) {
        ToDoItem toDoItem = (ToDoItem)view.getTag();
        Intent intent = new Intent(this, TodoItemDetail.class);
        intent.putExtra("todo", toDoItem);
        startActivity(intent);
    }

}
