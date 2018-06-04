package space.underscore.doyourthings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

public class TodoListAdapter extends ArrayAdapter<ToDoItem> {

    public TodoListAdapter(Context context, ArrayList<ToDoItem> todos) {
        super(context, 0, todos);
    }

    @Override
    public View getView(int position, View todoItemView, ViewGroup parent) {

        if (todoItemView == null) {
            todoItemView = LayoutInflater.from(getContext()).inflate(R.layout.todo_list_item, parent, false);
        }

        ToDoItem todo = getItem(position);

        CheckBox todoCheckBox = todoItemView.findViewById(R.id.todoCheckBox);
        todoCheckBox.setText(todo.getTitle());

        todoItemView.setTag(todo);

        return todoItemView;
    }

}
