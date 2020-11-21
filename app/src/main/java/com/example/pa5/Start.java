package com.example.pa5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    int SPLASH_DELAY = 2; //(2 Second Delay)

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        //Handler created to delay start screen with museum page
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Start.this, Museums.class));
                finish();
            }
        }, SPLASH_DELAY * 1000);
    }

    //DISABLE BACK BUTTON
    @Override
    public void onBackPressed(){
    }

}