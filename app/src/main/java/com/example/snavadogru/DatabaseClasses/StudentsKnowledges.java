package com.example.snavadogru.DatabaseClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentsKnowledges extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final  String DATABASE_NAME="Student.db";
    public static final  String TABLENAME=" Student";
    public static final  String COL_1="NAME";
    public StudentsKnowledges(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db){
        String sql="create table"+TABLENAME+"(NAME STRING not null)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Student");
        onCreate(db);
    }
    public void Open(){
        db = getWritableDatabase();
    }
    public void Close(){
        close();
    }
    public Students getStundent(){
        Students rt = new Students();
        String[] s=new String[1];
        s[0]=COL_1;
        Cursor c = db.query(TABLENAME,s,null,null,null,null,null);
        c.moveToFirst();
        rt.setName(c.getString(0));
        return rt;
    }
    public void StudentCreate(String isim,String phone){
        Students s = new Students();
        s.setName(isim);
        ContentValues val =new ContentValues();
        val.put(COL_1,isim );
        db.insert(TABLENAME,null,val);
    }
}