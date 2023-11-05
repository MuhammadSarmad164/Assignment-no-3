package com.example.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerceapp.databinding.ActivityLoginBinding;


public class activity_login extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.e1.getText().toString();
                String password = binding.e2.getText().toString();
                if (email.equals("") || password.equals(""))

                    Toast.makeText(activity_login.this, "All Fields are Mandatory", Toast.LENGTH_LONG).show();

                else {
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                    if (checkCredentials == true) {
                        Toast.makeText(activity_login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(activity_login.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(activity_login.this, "Invalid checkCredentials", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_signup.class);
                startActivity(intent);
            }
        });

    }
}
