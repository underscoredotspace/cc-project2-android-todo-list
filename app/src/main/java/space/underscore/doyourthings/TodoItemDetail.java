package space.underscore.doyourthings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TodoItemDetail extends AppCompatActivity {

    TextView todoTitle;
    TextView todoNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item_detail);

        todoTitle = findViewById(R.id.todoTitle);
        todoNotes = findViewById(R.id.todoNotes);
    }

    public void onSaveClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(this.getClass().toString(), "hello");

                String title = todoTitle.getText().toString();
                String notes = todoNotes.getText().toString();
                ToDoItem newTodo = new ToDoItem(title, notes);

                App.get().getDB().toDoItemDao().insert(newTodo);

                goBackToList();
            }
        }).start();
    }

    private void goBackToList() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
