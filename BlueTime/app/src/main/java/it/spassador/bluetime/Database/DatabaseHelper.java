package it.spassador.bluetime.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stefanopassador on 09/02/15.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = Database.DATABASE_NAME;
    private static final int DATABASE_VERSION = Database.DATABASE_VERSION;

    // Lo statement SQL di creazione del database
    private static final String TODO_CREATE = "" +
            "CREATE TABLE " + Database.TODO_TABLE + " ( " +
            Database.TODO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Database.TODO_TITLE + " TEXT NOT NULL, " +
            Database.TODO_DESCRIPTION + " TEXT, " +
            Database.TODO_LATITUDE + " REAL NOT NULL, " +
            Database.TODO_LONGITUDE + " REAL NOT NULL )";
    private static final String TASK_CREATE = "" +
            "CREATE TABLE " + Database.TASK_TABLE + " ( " +
            Database.TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Database.TASK_TITLE + " TEXT NOT NULL, " +
            Database.TASK_DESCRIPTION + " TEXT, " +
            Database.TASK_LATITUDE + " REAL NOT NULL, " +
            Database.TASK_LONGITUDE + " REAL NOT NULL )";

    // Costruttore
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Questo metodo viene chiamato durante la creazione del database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TODO_CREATE);
        database.execSQL(TASK_CREATE);
    }

    // Questo metodo viene chiamato durante l'upgrade del database, ad esempio quando viene incrementato il numero di versione
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + Database.TODO_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + Database.TASK_TABLE);
        onCreate(database);
    }
}
