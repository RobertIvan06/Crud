package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnAdopsi;
    TextView Nama,Kategori,Jenis_Kelamin,Umur,Berat,Tinggi,Detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        Nama = findViewById(R.id.Nama);
        Kategori = findViewById(R.id.Kategori);
        Jenis_Kelamin = findViewById(R.id.Jenis_Kelamin);
        Umur = findViewById(R.id.Umur);
        Berat = findViewById(R.id.Berat);
        Tinggi = findViewById(R.id.Tinggi);
        Detail = findViewById(R.id.Detail);
        btnAdopsi = findViewById(R.id.btnAdopsi);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Hewan WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount() >0){
            Nama.setText(cursor.getString(0).toString());
            Kategori.setText(cursor.getString(1).toString());
            Jenis_Kelamin.setText(cursor.getString(2).toString());
            Umur.setText(cursor.getString(3).toString());
            Berat.setText(cursor.getString(4).toString());
            Tinggi.setText(cursor.getString(5).toString());
            Detail.setText(cursor.getString(6).toString());
        }
    }
}