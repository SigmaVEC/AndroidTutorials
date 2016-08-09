package com.sigmavec.tut6sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 10/8/16.
 */
// 4. create a class and extend SQLiteOpenHelper
public class DbHandler extends SQLiteOpenHelper {
    // 5. create a constructor
    public DbHandler(Context c){
        super(c, "testDb", null, 1); // call the super class
    }

    // Generate the necessary Override methods
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 6. create the table
        String create = "CREATE TABLE sample (id INTEGER PRIMARY KEY, name TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 7. on app version change delete table and create again
        db.execSQL("DROP TABLE IF EXISTS sample");
        onCreate(db);
    }

    // 9.create function to store data
    public void insert(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();   // create a database object wit write permission
        ContentValues values = new ContentValues();
        values.put("id", id);      // put values
        values.put("name", name);

        db.insert("sample", null, values);  // insert into database
        db.close();
    }

    // 10. write a get method to get name
    public String get(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("sample",new String[]{"name"},"id=?",new String[]{id},null,null,null); // query the name of the id
        if (cursor != null)
            cursor.moveToFirst();

        if (cursor.getCount() > 0) // if element present get te name
            return cursor.getString(0);
        return "";
    }
}
