package it.spassador.bluetime.TDA;

import android.database.Cursor;

import it.spassador.bluetime.Database.Database;

/**
 * Created by stefanopassador on 11/04/15.
 */
public class Task extends TodoTask {
    public Task(Cursor cursor) {
        this.id = (int) cursor.getLong(cursor.getColumnIndex(Database.TASK_ID));
        this.title = cursor.getString(cursor.getColumnIndex(Database.TASK_TITLE));
        this.description = cursor.getString(cursor.getColumnIndex(Database.TASK_DESCRIPTION));
        this.latitude = cursor.getDouble(cursor.getColumnIndex(Database.TASK_LATITUDE));
        this.longitude = cursor.getDouble(cursor.getColumnIndex(Database.TASK_LONGITUDE));
    }
}
