package com.kelompok16.tugasppbkelompok16;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AbsenActivity extends AppCompatActivity {

    private DBHelper myDB;
    private RecyclerView rv;
    private ArrayList<Absen> absenArrayList;
    private AbsenAdapter absenAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        initWidget();

        showData();

        try {
            rv.setLayoutManager(new LinearLayoutManager(AbsenActivity.this));
            rv.setAdapter(absenAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void initWidget() {
        myDB = new DBHelper(AbsenActivity.this);
        rv = (RecyclerView) findViewById(R.id.rvDataAbsen);
        absenArrayList = new ArrayList<>();
        absenAdapter = new AbsenAdapter(absenArrayList);
    }

    void showData() {
        Cursor c = myDB.showDataAbsenRecyclerView();
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
    }

}