package com.kelompok16.tugasppbkelompok16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private String emailLogin = "";
    private TextView namaP, nimP;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initWidget();

        getDataIntent();


    }

    void initWidget(){
        namaP = (TextView) findViewById(R.id.tvNamaProfile);
        nimP = (TextView) findViewById(R.id.tvNIMProfile);
        imgProfile = (ImageView) findViewById(R.id.icProfile);
    }

    void getDataIntent(){
        Intent dashIntent = getIntent();
        emailLogin = dashIntent.getStringExtra("email");

        if(emailLogin.equals("refandasuryasaputra@gmail.com")){
            namaP.setText("Refanda Surya Saputra");
            nimP.setText("21120120120022");
            imgProfile.setImageResource(R.drawable.refanda);
        }else if(emailLogin.equals("imamnuralim@gmail.com")){
            namaP.setText("Imam Nuralim");
            nimP.setText("21120120120016");
            imgProfile.setImageResource(R.drawable.imam);
        }else if(emailLogin.equals("muhammadghulamabdul@gmail.com")){
            namaP.setText("Muhammad Ghulam Abdul Nasr");
            nimP.setText("21120120120029");
            imgProfile.setImageResource(R.drawable.ghulam);
        }else if(emailLogin.equals("muhammadrafianwar@gmail.com")){
            namaP.setText("Muhammad Rafi Anwar");
            nimP.setText("21120120140174");
            imgProfile.setImageResource(R.drawable.alif);
        }else if(emailLogin.equals("fatihrizkyhakim@gmail.com")){
            namaP.setText("Fatih Rizky Hakim");
            nimP.setText("21120120140170");
            imgProfile.setImageResource(R.drawable.fatih);
        }else if(emailLogin.equals("hafizhanjarsaputra@gmail.com")){
            namaP.setText("Hafizh Anjar Saputra");
            nimP.setText("21120120140143");
            imgProfile.setImageResource(R.drawable.hafizh);
        }
    }
}