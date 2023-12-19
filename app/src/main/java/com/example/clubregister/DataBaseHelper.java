package com.example.clubregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final  String DBNAME="Login.db";
    public  static final int DB_VERSION=2;

    public DataBaseHelper(Context context) {
        super(context, "Login.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(username TEXT primary key,password TEXT)");

        MyDB.execSQL("create table razzel(usn TEXT primary key, name TEXT, phone TEXT, branch TEXT, email TEXT)");
        MyDB.execSQL("create table chords(username TEXT, usn TEXT primary key, phone TEXT, branch TEXT, email TEXT)");
        MyDB.execSQL("create table captcha(username TEXT, usn TEXT primary key, phone TEXT, branch TEXT, email TEXT)");
        MyDB.execSQL("create table literature(username TEXT, usn TEXT primary key, phone TEXT, branch TEXT, email TEXT)");
        MyDB.execSQL("create table speakers(username TEXT, usn TEXT primary key, phone TEXT, branch TEXT, email TEXT)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i2) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists razzel");
        MyDB.execSQL("drop Table if exists chords");
        MyDB.execSQL("drop Table if exists captcha");
        MyDB.execSQL("drop Table if exists literature");
        MyDB.execSQL("drop Table if exists speakers");


    }
    public Boolean insertData(String username, String password)
    {
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=MyDB.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username=? and password =?",new String[]{username,password});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
    public boolean insertRazzelData(String usn, String name, String phone, String branch, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usn", usn);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("branch", branch);
        contentValues.put("email", email);
        long result = db.insert("razzel", null, contentValues);
        return result != -1;
    }
    public boolean insertchordsData(String usn, String name, String phone, String branch, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usn", usn);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("branch", branch);
        contentValues.put("email", email);
        long result = db.insert("chords", null, contentValues);
        return result != -1;
    }public boolean insertcaptchaData(String usn, String name, String phone, String branch, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usn", usn);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("branch", branch);
        contentValues.put("email", email);
        long result = db.insert("captcha", null, contentValues);
        return result != -1;
    }
    public boolean insertliteratureData(String usn, String name, String phone, String branch, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usn", usn);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("branch", branch);
        contentValues.put("email", email);
        long result = db.insert("literature", null, contentValues);
        return result != -1;
    }
    public boolean insertspeakerData(String usn, String name, int phone, String branch, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usn", usn);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("branch", branch);
        contentValues.put("email", email);
        long result = db.insert("speaker", null, contentValues);
        return result != -1;
    }


    // ... existing code ...

    // Method to fetch data from the "razzel" table
    public Cursor getRazzelData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM razzel", null);
    }

    // Method to fetch data from the "chords" table
    public Cursor getChordsData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM chords", null);
    }

    public Cursor getcaptchaData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM captcha", null);
    }

    public Cursor getliteratureData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM literature", null);
    }

    public Cursor getspeakersData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM speakers", null);
    }




    // ... existing code ...





}