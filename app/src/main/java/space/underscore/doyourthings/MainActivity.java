package space.underscore.doyourthings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToDoList todos = new ToDoList();
        ArrayList<ToDoItem> todo = todos.getAll();

        TodoListAdapter todosAdapter = new TodoListAdapter(this, todo);

        ListView todoListView = findViewById(R.id.todoListView);
        todoListView.setAdapter(todosAdapter);
    }

    public void onListItemClick(View todoItem) {
        ToDoItem todo = (ToDoItem) todoItem.getTag();
    }

}
