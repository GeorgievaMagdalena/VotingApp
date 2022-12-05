package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="information.db";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_NAME="user_data";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_SURNAME="surname";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_EMAIL="email";
    private static final String COlUMN_PASSWORD="password";

    SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);;
        database=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME +"("+COLUMN_ID+"INTEGER PRIMARY KEY, "+COLUMN_NAME+" TEXT, "+ COLUMN_SURNAME+" TEXT, "+ COLUMN_USERNAME+" TEXT, "+ COLUMN_EMAIL+" TEXT, "+ COlUMN_PASSWORD+" TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void RegisterUser(String name, String surname, String username, String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues vl=new ContentValues();

        vl.put(COLUMN_NAME,name);
        vl.put(COLUMN_SURNAME,surname);
        vl.put(COLUMN_USERNAME,username);
        vl.put(COLUMN_EMAIL,email);
        vl.put(COlUMN_PASSWORD,password);

        db.insert(TABLE_NAME,null,vl);
        db.close();
    }

}
