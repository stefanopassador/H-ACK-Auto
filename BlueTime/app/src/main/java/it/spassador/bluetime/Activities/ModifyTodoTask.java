package it.spassador.bluetime.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.Database.DatabaseAdapter;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.Task;
import it.spassador.bluetime.TDA.Todo;
import it.spassador.bluetime.TDA.TodoTask;

public class ModifyTodoTask extends ActionBarActivity {
    EditText editTextTitle;
    EditText editTextDescription;
    EditText editTextLatitude;
    EditText editTextLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_todo_task);

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
        editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt(CommonUtilities.TODO_TASK_ID);
        boolean isTodo = bundle.getString(CommonUtilities.TODO_TASK).equalsIgnoreCase("todo");

        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        db.open();
        Cursor cursor;
        TodoTask todoTask;
        if (isTodo) {
            cursor = db.fetchTodo(id);
            cursor.moveToFirst();
            todoTask = new Todo(cursor);
            cursor.close();
        } else {
            cursor = db.fetchTask(id);
            cursor.moveToFirst();
            todoTask = new Task(cursor);
            cursor.close();
        }
        db.close();
        setTitle(todoTask.getTitle());

        editTextTitle.setText(todoTask.getTitle());
        editTextDescription.setText(todoTask.getDescription());
        editTextLatitude.setText(todoTask.getLatitude() + "");
        editTextLongitude.setText(todoTask.getLongitude() + "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modify_todo_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
