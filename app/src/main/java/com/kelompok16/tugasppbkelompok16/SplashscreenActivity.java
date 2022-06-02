package com.kelompok16.tugasppbkelompok16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity {

    TextView txtSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        txtSplash = (TextView) findViewById(R.id.txtJudulSplash);

        Animation animation = AnimationUtils.loadAnimation(SplashscreenActivity.this, R.anim.fadeout);

        txtSplash.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashscreenActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}