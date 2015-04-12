package it.spassador.bluetime.Database;

/**
 * Created by stefanopassador on 09/02/15.
 */

public class Database {
    public static final String DATABASE_NAME = "bluetime.db";
    public static final int DATABASE_VERSION = 1;

    // String for to_do table
    public static final String TODO_TABLE = "todo";
    public static final String TODO_ID = "_id";
    public static final String TODO_TITLE = "title";
    public static final String TODO_DESCRIPTION = "description";
    public static final String TODO_LATITUDE = "latitude";
    public static final String TODO_LONGITUDE = "longitude";

    // String for task table
    public static final String TASK_TABLE = "task";
    public static final String TASK_ID = "_id";
    public static final String TASK_TITLE = "title";
    public static final String TASK_DESCRIPTION = "description";
    public static final String TASK_LATITUDE = "latitude";
    public static final String TASK_LONGITUDE = "longitude";
}
