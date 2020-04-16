package com.example.mattias.movietest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class SplashActivity extends AppCompatActivity {
    private long splashTime = 3000L;
    private Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        myHandler = new Handler();
        myHandler.postDelayed(
            new Runnable() { @Override public void run() { goToMainActivity(); }},
            splashTime);
    }

    private void goToMainActivity() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
