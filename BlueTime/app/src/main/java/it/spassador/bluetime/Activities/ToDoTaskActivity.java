package it.spassador.bluetime.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import it.spassador.bluetime.Adapters.TodoTaskAdapter;
import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.Database.DatabaseAdapter;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.Task;
import it.spassador.bluetime.TDA.Todo;
import it.spassador.bluetime.TDA.TodoTask;


public class ToDoTaskActivity extends ActionBarActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_task);

        mListView = (ListView) findViewById(R.id.list_view);

        ArrayList<TodoTask> arrayList = new ArrayList<TodoTask>();
        boolean isTodo = true;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString(CommonUtilities.TODO_TASK).equalsIgnoreCase("task")) {
                isTodo = false;
            }
        }

        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        db.open();
        if (isTodo) {
            setTitle("Todo");
            Cursor cursor = db.fetchAllTodo();
            TodoTask todoTask;
            while (cursor.moveToNext()) {
                todoTask = new Todo(cursor);
                arrayList.add(todoTask);
            }
        } else {
            setTitle("Task");
            Cursor cursor = db.fetchAllTask();
            TodoTask todoTask;
            while (cursor.moveToNext()) {
                todoTask = new Task(cursor);
                arrayList.add(todoTask);
            }
        }

        TodoTaskAdapter arrayAdapter = new TodoTaskAdapter(getApplicationContext(), arrayList);
        mListView.setAdapter(arrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_to_do_task, menu);
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
