package com.example.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductInfo extends AppCompatActivity {
     ImageView productImageView;
     TextView productDecriptionView,productRemainingView,productNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        productImageView=findViewById(R.id.productImage);
        productDecriptionView=findViewById(R.id.descriptionProduct);
        productRemainingView=findViewById(R.id.remainingProduct);
        productNameView=findViewById(R.id.productName);

        Intent recivedIntent=getIntent();

        String nameOfProduct=recivedIntent.getStringExtra("product_name");
        String descriptionOfProduct=recivedIntent.getStringExtra("desciptionProduct");
        String remainingProduct=recivedIntent.getStringExtra("remainingProduct");
        int flagOfimg=recivedIntent.getIntExtra("image_data",R.drawable.soap);


        productImageView.setImageResource(flagOfimg);
        productNameView.setText(nameOfProduct);
        productRemainingView.setText(remainingProduct);
        productDecriptionView.setText(descriptionOfProduct);

    }
}

