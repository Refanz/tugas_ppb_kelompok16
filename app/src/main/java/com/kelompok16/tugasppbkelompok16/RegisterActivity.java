package com.kelompok16.tugasppbkelompok16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    EditText etEMail, etPassword, etConfPassword;
    MaterialButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initWidget();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO

            }
        });


    }

    void initWidget(){
        etEMail = (EditText) findViewById(R.id.etRegEmail);
        etPassword = (EditText) findViewById(R.id.etRegPass);
        etConfPassword = (EditText) findViewById(R.id.etRegConfPass);
        btnRegister = (MaterialButton) findViewById(R.id.btnRegister);
    }
}