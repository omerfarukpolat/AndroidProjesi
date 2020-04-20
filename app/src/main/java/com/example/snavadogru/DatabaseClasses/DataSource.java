package com.example.snavadogru.DatabaseClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {
    SQLiteDatabase db;
    DataBaseLayer lbd;
    public DataSource(Context context){
        lbd = new DataBaseLayer(context);
    }
    public void Open(){
        db = lbd.getWritableDatabase();
    }

    public void Close(){
        lbd.close();
    }

    public void StudentCreate(String isim,String phone){

        ContentValues val =new ContentValues();
        val.put(lbd.COL_2,isim );
        db.insert(lbd.TABLENAME,null,val);
    }
/*
    public List<Students> listele(){
        String columns[]={"id","name"};
        ArrayList<> Ustalar = new ArrayList<>();
        Cursor c = db.query("usta",columns,null,null,null,null,null);
        c.moveToFirst();
        int id;
        String name;
        int i=0;
        while(!c.isAfterLast())
        {   Usta u = new Usta();
            id = c.getInt(0);
            name = c.getString(1);
            u.setId(id);
            u.setName(name);
            Ustalar.add(u);
            c.moveToNext();
            Log.d("DEBUG",Ustalar.get(i++).getName());
        }
        c.close();
        Log.d("Gitmeden once",Ustalar.get(1).getName());
        return Ustalar;
    }*/
}
