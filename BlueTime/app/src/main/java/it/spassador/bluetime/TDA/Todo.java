package it.spassador.bluetime.TDA;

import android.database.Cursor;

import it.spassador.bluetime.Database.Database;

/**
 * Created by stefanopassador on 11/04/15.
 */
public class Todo extends TodoTask {
    public Todo(Cursor cursor) {
        this.id = (int) cursor.getLong(cursor.getColumnIndex(Database.TODO_ID));
        this.title = cursor.getString(cursor.getColumnIndex(Database.TODO_TITLE));
        this.description = cursor.getString(cursor.getColumnIndex(Database.TODO_DESCRIPTION));
        this.latitude = cursor.getDouble(cursor.getColumnIndex(Database.TODO_LATITUDE));
        this.longitude = cursor.getDouble(cursor.getColumnIndex(Database.TODO_LONGITUDE));
    }

    public int getType() {
        return 1;
    }

}
