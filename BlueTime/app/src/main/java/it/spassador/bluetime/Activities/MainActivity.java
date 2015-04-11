package it.spassador.bluetime.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import it.spassador.bluetime.Adapters.GridViewAdapter;
import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.Database.DatabaseAdapter;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.TodoTask;


public class MainActivity extends ActionBarActivity {
    GridView mGridView;
    ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Bitmap> arrayImages = new ArrayList();
        arrayImages.add(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.ic_todo, 200, 200));
        arrayImages.add(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.ic_wishlist, 200, 200));
        arrayImages.add(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.ic_likes, 200, 200));
        arrayImages.add(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.ic_profile, 200, 200));
        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setAdapter(new GridViewAdapter(MainActivity.this, R.layout.row_grid_view, arrayImages));
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0:
                        Intent intent1 = new Intent(getApplicationContext(), ToDoTaskActivity.class);
                        intent1.putExtra(CommonUtilities.TODO_TASK, "todo");
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), ToDoTaskActivity.class);
                        intent2.putExtra(CommonUtilities.TODO_TASK, "task");
                        startActivity(intent2);
                        break;
                    default:
                        break;
                }
            }
        });

        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        db.open();
        Cursor cursor = db.fetchAllTodo();
        if (cursor != null && cursor.getCount() == 0) {
            // Insert test To_Do
            db.createTodo("Consegnare raccomandata", "Consegnare raccomandata presso: Poste Italiane", 45.4917223, 12.2395232);
            db.createTodo("Prelevamento denaro", "Prelevamento denaro presso: Veneto Banca", 45.4843635,12.2528873);
            db.createTodo("Tagliando macchina", "Tagliando macchina presso officina autorizzata Ford", 45.4824105,12.2751942);
            db.createTodo("Fare la spesa", "Andare a fare la spesa", 45.510896,12.227275);
        }
        cursor.close();
        cursor = db.fetchAllTask();
        if (cursor != null && cursor.getCount() == 0) {
            // Insert test Task
            db.createTask("Acquisto GoPro", "Mediaworld", 45.517038,12.233961);
            db.createTask("Iphone 6", "Apple Store", 45.459426, 12.212354);
            db.createTask("Trapano", "Leroy Merlin",  45.459426, 12.212354);
            db.createTask("Camicia", "Green Records, Abbigliamento", 45.49411, 12.245618);
        }
        cursor.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
