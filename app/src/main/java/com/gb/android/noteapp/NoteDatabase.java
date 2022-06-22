package com.gb.android.noteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "notedb";
    private static final String DATABASE_TABLE = "notestable";

    //имена столбцов для таблицы базы данных
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    NoteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //создание таблицы
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE +
                " (" +
                KEY_ID + " INT PRIMARY KEY," +
                KEY_TITLE+" TEXT," +
                KEY_CONTENT + " TEXT," +
                KEY_DATE + " TEXT," +
                KEY_TIME + " TEXT" + " )";
        db.execSQL(query);
    }

    //обновить БД, если существует более старая версия
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
}
