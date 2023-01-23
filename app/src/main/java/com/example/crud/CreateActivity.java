package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnsimpan;
    EditText etNama,etKategori,etJenis_Kelamin,etUmur,etBerat,etTinggi,etDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this);
        etNama = findViewById(R.id.etNama);
        etKategori = findViewById(R.id.etKategori);
        etJenis_Kelamin = findViewById(R.id.etJenis_Kelamin);
        etUmur = findViewById(R.id.etUmur);
        etBerat = findViewById(R.id.etBerat);
        etTinggi = findViewById(R.id.etTinggi);
        etDetail = findViewById(R.id.etDetail);
        btnsimpan = findViewById(R.id.btnSimpan);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO hewan(nama,kategori,jenis_kelamin,umur,berat,tinggi,detail) values('"+
                        etNama.getText().toString() + "','" +
                        etKategori.getText().toString() + "','" +
                        etJenis_Kelamin.getText().toString() + "','" +
                        etUmur.getText().toString() + "','" +
                        etBerat.getText().toString() + "','" +
                        etTinggi.getText().toString() + "','" +
                        etDetail.getText().toString() + "')");
                Toast.makeText(CreateActivity.this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}