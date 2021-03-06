package space.underscore.doyourthings.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import space.underscore.doyourthings.R;

public class TodoListAdapter extends ArrayAdapter<ToDoItem> {

    public TodoListAdapter(Context context, List<ToDoItem> todos) {
        super(context, 0, todos);
    }

    @Override
    public View getView(int position, View todoItemView, ViewGroup parent) {

        if (todoItemView == null) {
            todoItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }

        ToDoItem todo = getItem(position);

        TextView todoTitle = todoItemView.findViewById(R.id.todoTitle);
        todoTitle.setText(todo.getTitle());

        CheckBox todoDone = todoItemView.findViewById(R.id.todoCheckBox);

        todoItemView.setTag(todo);
        todoTitle.setTag(todo);

        todoDone.setTag(todo);
        todoDone.setChecked(todo.isDone());

        return todoItemView;
    }

}
