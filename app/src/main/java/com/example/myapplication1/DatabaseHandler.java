package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    private static final String TABLE_POLL="questions_data";
    private static final String COLUMN_IDP="id1";
    private static final String COLUMN_QUESTION="question";
    private static final String COLUMN_OPTION1="option1";
    private static final String COLUMN_OPTION2="option2";
    private static final String COLUMN_OPTION3="option3";
    private static final String COLUMN_OPTION4="option4";
    private static final String COLUMN_OPTION5="option5";

    SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT, "+ COLUMN_SURNAME+" TEXT, "+ COLUMN_USERNAME+" TEXT, "+ COLUMN_EMAIL+" TEXT, "+ COlUMN_PASSWORD+" TEXT) ");
        db.execSQL(" CREATE TABLE "+TABLE_POLL+" ( "+COLUMN_IDP+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_QUESTION+" TEXT, "+COLUMN_OPTION1+" TEXT, "+COLUMN_OPTION2+" TEXT, "+COLUMN_OPTION3+" TEXT, "+COLUMN_OPTION4+" TEXT, "+COLUMN_OPTION5+" TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_POLL);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


    public boolean RegisterUser(UserModel um){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        //cv.put(COLUMN_ID, um.getId());
        cv.put(COLUMN_NAME, um.getName());
        cv.put(COLUMN_SURNAME,um.getSurname());
        cv.put(COLUMN_USERNAME,um.getUsername());
        cv.put(COLUMN_EMAIL,um.getEmail());
        cv.put(COlUMN_PASSWORD,um.getPassword());

        long insert=db.insert(TABLE_NAME,null,cv);
        db.close();

        if(insert==-1){
            return false;
        }else{
            return true;
        }

    }

    public boolean AddQuestion(QuestionModel qm){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cval=new ContentValues();

        //cval.put(COLUMN_IDP, qm.getId1());
        cval.put(COLUMN_QUESTION, qm.getQuestion());
        cval.put(COLUMN_OPTION1, qm.getOption1());
        cval.put(COLUMN_OPTION2, qm.getOption2());
        cval.put(COLUMN_OPTION3, qm.getOption3());
        cval.put(COLUMN_OPTION4, qm.getOption4());
        cval.put(COLUMN_OPTION5, qm.getOption5());

        long insert=db.insert(TABLE_POLL,null,cval);
        db.close();

        if(insert==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase info=this.getWritableDatabase();
        Cursor cursor=info.rawQuery("Select * from "+TABLE_NAME+" where "+COLUMN_EMAIL+" =? ", new String[]{email});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase info=this.getWritableDatabase();
        Cursor cursor=info.rawQuery("Select * from "+TABLE_NAME+" where "+COLUMN_EMAIL+" =? and "+COlUMN_PASSWORD+" =? ", new String[]{email, password});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }

    public Cursor getQuestion()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABLE_POLL, null);
        return cursor;
    }


}
