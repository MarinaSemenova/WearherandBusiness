package com.example.halatongis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME= "contactDb";
    private static String TABLE_CONTACTS="contacts";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MAIL = "mail";

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_CONTACTS + "("+ KEY_ID + "integer primary key," + KEY_NAME+ "text,"+ KEY_MAIL+ "text"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + TABLE_CONTACTS);

        onCreate(db);

    }

}
