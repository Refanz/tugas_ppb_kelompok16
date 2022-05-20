package com.kelompok16.tugasppbkelompok16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnLogin;
    EditText etEmail, etPassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    void initWidget(){
        btnLogin = (MaterialButton) findViewById(R.id.btnLoginP);
        etEmail = (EditText) findViewById(R.id.editEmail);
        etPassword = (EditText) findViewById(R.id.editPassword);
        DB = new DBHelper(this);
    }
}