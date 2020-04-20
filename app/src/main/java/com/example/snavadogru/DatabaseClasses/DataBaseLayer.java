package com.example.snavadogru.DatabaseClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseLayer extends SQLiteOpenHelper  {
        public static final  String DATABASE_NAME="Gallery.db";
        public static final  String TABLENAME=" Photo";
        public static final  String COL_2="PHOTO_NAME";
        public DataBaseLayer(Context context){
            super(context,DATABASE_NAME,null,1);
        }

        public void onCreate(SQLiteDatabase db){
            String sql="create table"+TABLENAME+"(ID integer primary key autoincrement,PHOTO_NAME STRING not null)";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Photo");
            onCreate(db);
        }

}
