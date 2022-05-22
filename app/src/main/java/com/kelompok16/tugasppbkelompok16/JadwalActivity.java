package com.kelompok16.tugasppbkelompok16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class JadwalActivity extends AppCompatActivity {

    private CalendarView cvCalendar;
    private TextView tvSetDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        initWidget();

        cvCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month+1) + "/" + year;
                tvSetDate.setText(date);
            }
        });
    }

    void initWidget(){
        cvCalendar = (CalendarView) findViewById(R.id.cvCalendar);
        tvSetDate = (TextView) findViewById(R.id.txtDate);
    }
}