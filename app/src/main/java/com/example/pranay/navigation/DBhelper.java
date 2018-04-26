package com.example.pranay.navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pranay on 4/16/2018.
 */

public class DBhelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";

    public DBhelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Hero.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Hero.TABLE_NAME);

        // Create tables again
        onCreate(db);

    }

    public long insertBookmark(String link,String head) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Hero.COLUMN_L,link);
        values.put(Hero.COLUMN_H,head);

        // insert row
        long id = db.insert(Hero.TABLE_NAME, null, values);

        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }

    public void deleteBookmark(String link,String head) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Hero.TABLE_NAME, Hero.COLUMN_H + " = ?",
                new String[]{String.valueOf(head)});
        db.close();
    }

    public int getBookmarkCount() {
        String countQuery = "SELECT  * FROM " + Hero.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
}
