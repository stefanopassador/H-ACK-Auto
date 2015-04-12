package it.spassador.bluetime.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by stefanopassador on 09/02/15.
 */

public class DatabaseAdapter {
    private static final String LOG_TAG = DatabaseAdapter.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DatabaseAdapter(Context context) {
        this.context = context;
    }

    public DatabaseAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValuesTodo(String title, String description,
                                                  Double latitude, Double longitude) {
        ContentValues values = new ContentValues();
        values.put(Database.TODO_TITLE, title);
        values.put(Database.TODO_DESCRIPTION, description);
        values.put(Database.TODO_LATITUDE, latitude);
        values.put(Database.TODO_LONGITUDE, longitude);

        return values;
    }

    private ContentValues createContentValuesTask(String title, String description,
                                                  Double latitude, Double longitude) {
        ContentValues values = new ContentValues();
        values.put(Database.TASK_TITLE, title);
        values.put(Database.TASK_DESCRIPTION, description);
        values.put(Database.TASK_LATITUDE, latitude);
        values.put(Database.TASK_LONGITUDE, longitude);

        return values;
    }

    //create a to_do
    public long createTodo(String title, String description, Double latitude, Double longitude) {
        ContentValues initialValues = createContentValuesTodo(title, description, latitude, longitude);
        return database.insertOrThrow(Database.TODO_TABLE, null, initialValues);
    }

    //create a task
    public long createTask(String title, String description, Double latitude, Double longitude) {
        ContentValues initialValues = createContentValuesTask(title, description, latitude, longitude);
        return database.insertOrThrow(Database.TASK_TABLE, null, initialValues);
    }

/*
    //update a contact
    public boolean updateCondominium(long condominiumId, String name, String address, String valveBrand, String splitterBrand) {
        ContentValues updateValues = createContentValuesCondominium(name, address, valveBrand, splitterBrand);
        return database.update(CONDOMINIUMS_TABLE, updateValues, CONDOMINIUMS_ID + "=" + condominiumId, null) > 0;
    }


    //delete a condominium
    public boolean deleteCondominium(long condominiumId) {
        return database.delete(CONDOMINIUMS_TABLE, CONDOMINIUMS_ID + "=" + condominiumId, null) > 0;
    }
*/

    //fetch all to_do
    public Cursor fetchTodo(int id) {
        return database.query(Database.TODO_TABLE, new String[]{Database.TODO_ID, Database.TODO_TITLE,
                Database.TODO_DESCRIPTION, Database.TODO_LATITUDE, Database.TODO_LONGITUDE}, Database.TODO_ID + " = " + id, null, null, null, null);
    }

    //fetch all to_do
    public Cursor fetchTask(int id) {
        return database.query(Database.TASK_TABLE, new String[]{Database.TASK_ID, Database.TASK_TITLE,
                Database.TASK_DESCRIPTION, Database.TASK_LATITUDE, Database.TASK_LONGITUDE}, Database.TASK_ID + " = " + id, null, null, null, null);
    }

    //fetch all to_do
    public Cursor fetchAllTodo() {
        return database.query(Database.TODO_TABLE, new String[]{Database.TODO_ID, Database.TODO_TITLE,
                Database.TODO_DESCRIPTION, Database.TODO_LATITUDE, Database.TODO_LONGITUDE}, null, null, null, null, null);
    }

    //fetch all task
    public Cursor fetchAllTask() {
        return database.query(Database.TASK_TABLE, new String[]{Database.TASK_ID, Database.TASK_TITLE,
                Database.TASK_DESCRIPTION, Database.TASK_LATITUDE, Database.TASK_LONGITUDE}, null, null, null, null, null);
    }

}

