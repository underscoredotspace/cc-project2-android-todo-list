package space.underscore.doyourthings.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import space.underscore.doyourthings.App;
import space.underscore.doyourthings.R;
import space.underscore.doyourthings.model.ToDoItem;

public class DetailActivity extends AppCompatActivity {

    TextView todoTitle;
    TextView todoNotes;
    ToDoItem todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        todoTitle = findViewById(R.id.todoTitle);
        todoNotes = findViewById(R.id.todoNotes);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Add Todo");


        Intent intent = getIntent();
        todo = (ToDoItem)intent.getSerializableExtra("todo");

        if (todo != null) {
            ab.setTitle("Edit Todo");
            todoTitle.setText(todo.getTitle());
            todoNotes.setText(todo.getNotes());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.detail_menu, menu);

        if (todo == null) {
            menu.findItem(R.id.delete).setVisible(false);
        }

        return true;
    }

    public void onSaveButtonClick(MenuItem item) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            if (todo != null) {
                todo.setTitle(todoTitle.getText().toString());
                todo.setNotes(todoNotes.getText().toString());
                App.get().getDB().toDoItemDao().update(todo);
                doToast("updated");
            } else {
                String title = todoTitle.getText().toString();
                String notes = todoNotes.getText().toString();
                ToDoItem newTodo = new ToDoItem(title, notes);
                App.get().getDB().toDoItemDao().insert(newTodo);
                doToast("added");
            }

            goBackToList();
            }
        }).start();
    }

    private void goBackToList() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onDeleteButtonClick(MenuItem item) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                App.get().getDB().toDoItemDao().delete(todo);
                doToast("deleted");
                goBackToList();
            }
        }).start();
    }

    private void doToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DetailActivity.this, "Todo " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
