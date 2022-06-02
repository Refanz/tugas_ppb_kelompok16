package com.kelompok16.tugasppbkelompok16;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AbsenActivity extends AppCompatActivity {

    private DBHelper myDB;
    private RecyclerView rv;
    private ArrayList<Absen> absenArrayList;
    private AbsenAdapter adapter;
    private String nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        initWidget();

        rv.setHasFixedSize(true);

        showRecyclerview();

        getDataIntent();

        showData(nim);

    }

    void showRecyclerview(){
        rv.setLayoutManager(new LinearLayoutManager(AbsenActivity.this));
        rv.setAdapter(adapter);
    }

    void getDataIntent(){
        Intent intent = getIntent();
        nim = intent.getStringExtra("nimLogin");
    }

    void initWidget() {
        myDB = new DBHelper(AbsenActivity.this);
        rv = (RecyclerView) findViewById(R.id.rvDataAbsen);
        absenArrayList = new ArrayList<>();
        adapter = new AbsenAdapter(absenArrayList);
    }

    void showData(String nims) {
        absenArrayList.clear();

        Cursor c = myDB.getDataAbsen(nims);
        while (c.moveToNext()) {
            String id = c.getString(0);
            String nim = c.getString(1);
            String nama = c.getString(2);
            String tanggal = c.getString(3);
            String jam = c.getString(4);
            String status = c.getString(5);

            Absen absen = new Absen(id, nim, nama, tanggal, jam, status);

            System.out.println("ID: " + id +
                    "nim: " + nim +
                    "nama: " + nama +
                    "tanggal: " + tanggal +
                    "jam: " + jam +
                    "status: " + status);

            absenArrayList.add(absen);
        }

        if(!(absenArrayList.size() < 1))
            rv.setAdapter(adapter);
    }

}