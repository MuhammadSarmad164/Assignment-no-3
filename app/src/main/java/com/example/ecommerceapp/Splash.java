package com.example.ecommerceapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView i1 = findViewById(R.id.i1);
        TextView t1 = findViewById(R.id.t1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, activity_login.class);
                startActivity(mainIntent);
                finish();
            }
        }, 6000);
        Toast.makeText(this, "Enjoy Travel App", Toast.LENGTH_SHORT).show();
    }
}