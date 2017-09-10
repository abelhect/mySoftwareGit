package com.example.android.genericapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by abelhectMACHOME on 2/23/16.
 * This javaclass is to create the database that will house the user information once registered.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /**Declaring the name of my database*/
    private static final String DATABASE_NAME    ="user.db";
    private static final String TABLE_NAME    ="Users_Table";
    private static final String COL_ID    ="ID";
    private static final String COL_NAME    ="NAME";
    private static final String COL_SURNAME    ="SURNAME";
    private static final String COL_AGE    ="AGE";
    private static final String COL_EMAIL    ="EMAIL";
    private static final String COL_PASS    ="PASSWORD";

    /**Constructor that creates the database*/
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                " %s TEXT, %s TEXT, %s INTEGER, %s NVARCHAR, %s TEXT);", TABLE_NAME, COL_ID, COL_NAME, COL_SURNAME,
                COL_AGE, COL_EMAIL, COL_PASS );
        db.execSQL(CREATE_USER_TABLE);
    }
/** this removes table if it exists and creates a new one i believe*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF IT EXISTS" +TABLE_NAME);
        onCreate(db);
    }
/** this is the method to insert the values in the database*/
    public boolean insertData (String NAME, String SURNAME, String AGE, String EMAIL, String PASSWORD){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_NAME,NAME);
        contentValues.put(COL_SURNAME,SURNAME);
        contentValues.put(COL_AGE,AGE);
        contentValues.put(COL_EMAIL,EMAIL);
        contentValues.put(COL_PASS,PASSWORD);
        long result = db.insert(TABLE_NAME,null,contentValues);
        /** testing that the method actually did its job of inserting the values*/
        if (result == -1)
            return false;
        else
            return true;
    }
}