package com.example.pformalt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSetup extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Exercises.db";
    public static final String TABLE_NAME = "exercise_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "WORKOUT";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "LINK";


    public DataBaseSetup(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, WORKOUT TEXT, DESCRIPTION TEXT, LINK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
