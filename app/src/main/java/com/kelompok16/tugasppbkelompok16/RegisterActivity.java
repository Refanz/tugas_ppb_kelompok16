package com.kelompok16.tugasppbkelompok16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    EditText etEMail, etPassword, etConfPassword;
    MaterialButton btnRegister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initWidget();

        //Buttom Register
        btnRegister.setOnClickListener(v -> {
            try {
                String email = etEMail.getText().toString();
                String password = etPassword.getText().toString();
                String confPassword = etConfPassword.getText().toString();

                if(email.equals("") || password.equals("") || confPassword.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confPassword)) {
                        boolean checkEmail = DB.checkEmail(email);
                        if(!checkEmail){
                            boolean insert = DB.insertData(email, password);
                            if(insert){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "User already exist!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (Exception e){
                System.out.println("Mesaage: "+e);
            }
        });

    }

    void initWidget(){
        etEMail = (EditText) findViewById(R.id.etRegEmail);
        etPassword = (EditText) findViewById(R.id.etRegPass);
        etConfPassword = (EditText) findViewById(R.id.etRegConfPass);
        btnRegister = (MaterialButton) findViewById(R.id.btnRegister);
        DB = new DBHelper(RegisterActivity.this);
    }
}