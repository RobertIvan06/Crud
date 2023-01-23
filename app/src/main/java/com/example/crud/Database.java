package com.example.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="PetShop.db";
    private static final int DATABASE_VERSION = 1;

    public Database (Context context){
        super (context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE hewan (nama text null,kategori text null,jenis_kelamin text null,umur number null,berat number null,tinggi number null,detail text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {

    }
}
