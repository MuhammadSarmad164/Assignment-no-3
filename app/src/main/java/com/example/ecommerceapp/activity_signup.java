package com.example.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerceapp.databinding.ActivitySignupBinding;


public class activity_signup extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);
        binding.b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email=binding.e3.getText().toString();
                String password=binding.e4.getText().toString();
                String confirmPassword=binding.e5.getText().toString();

                if(email.equals("") || password.equals("") || confirmPassword.equals(""))
                    Toast.makeText(activity_signup.this, "All Fields are Mandatory", Toast.LENGTH_LONG).show();
                else{
                    if(password.equals(confirmPassword)){
                        Boolean checkUserEmail= databaseHelper.checkEmail(email);
                        if (checkUserEmail==false){
                            Boolean insert=databaseHelper.insertData(email,password);
                            if (insert==true){
                                Toast.makeText(activity_signup.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),activity_login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(activity_signup.this, "Sign Up Failed", Toast.LENGTH_LONG).show();
                            }

                        }
                        else {
                            Toast.makeText(activity_signup.this, "User Already exists, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(activity_signup.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),activity_login.class);
                startActivity(intent);
            }
        });

    }
}