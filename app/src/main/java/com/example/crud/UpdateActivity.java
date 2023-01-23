package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnsimpan;
    EditText etNama,etKategori,etJenis_Kelamin,etUmur,etBerat,etTinggi,etDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this);
        etNama = findViewById(R.id.etNama);
        etKategori = findViewById(R.id.etKategori);
        etJenis_Kelamin = findViewById(R.id.etJenis_Kelamin);
        etUmur = findViewById(R.id.etUmur);
        etBerat = findViewById(R.id.etBerat);
        etTinggi = findViewById(R.id.etTinggi);
        etDetail = findViewById(R.id.etDetail);
        btnsimpan = findViewById(R.id.btnSimpan);

        SQLiteDatabase db=database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM hewan WHERE nama = '"+
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();

        if(cursor.getCount() >0){
            cursor.moveToPosition(0);
            etNama.setText(cursor.getString(0).toString());
            etKategori.setText(cursor.getString(1).toString());
            etJenis_Kelamin.setText(cursor.getString(2).toString());
            etUmur.setText(cursor.getString(3).toString());
            etBerat.setText(cursor.getString(4).toString());
            etTinggi.setText(cursor.getString(5).toString());
            etDetail.setText(cursor.getString(6).toString());
        }

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("UPDATE Hewan set nama='"+
                etNama.getText().toString() +"', kategori='" +
                etKategori.getText().toString() +"', jenis_kelamin='" +
                etJenis_Kelamin.getText().toString() +"', umur='" +
                etUmur.getText().toString() +"', berat='"+
                etBerat.getText().toString() +"', tinggi='"+
                etTinggi.getText().toString() +"', detail='"+
                etDetail.getText().toString() +"' WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'");
                Toast.makeText(UpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}