package com.example.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SelectListener{
     RecyclerView recyclerView;
     CustomAdapter adapter;
     ArrayList<ModelClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.RecyclerView);
        arrayList=new ArrayList<>();

        arrayList.add(new ModelClass(R.drawable.t1, "Pantene is known for its Pro-V formula, offering healthy and shiny hair.", "Itely", "9"));
        arrayList.add(new ModelClass(R.drawable.t2, "Head & Shoulders is a trusted brand for dandruff control, ensuring a healthy scalp.", "Paris", "8"));
        arrayList.add(new ModelClass(R.drawable.t3, "Dove's shampoos provide nourishment and moisture, leaving hair soft and manageable.", "London", "8"));
        arrayList.add(new ModelClass(R.drawable.t4, "L'Oréal Paris offers advanced formulas and luxurious results for various hair concerns.", "Murre", "8"));
        arrayList.add(new ModelClass(R.drawable.t5, "Herbal Essences infuses natural ingredients for a refreshing and aromatic hair-washing experience.", "Dubai", "8"));
        arrayList.add(new ModelClass(R.drawable.t6, "Garnier's shampoos focus on the power of fruits and botanicals for healthy and vibrant hair.", "Germany", "8"));
        arrayList.add(new ModelClass(R.drawable.t1, "Pantene is known for its Pro-V formula, offering healthy and shiny hair.", "China", "9"));
        arrayList.add(new ModelClass(R.drawable.t5, "Head & Shoulders is a trusted brand for dandruff control, ensuring a healthy scalp.", "Koria", "8"));
        arrayList.add(new ModelClass(R.drawable.t4, "Dove's shampoos provide nourishment and moisture, leaving hair soft and manageable.", "India", "8"));
        arrayList.add(new ModelClass(R.drawable.t3, "L'Oréal Paris offers advanced formulas and luxurious results for various hair concerns.", "Japan", "8"));
        arrayList.add(new ModelClass(R.drawable.t2, "Herbal Essences infuses natural ingredients for a refreshing and aromatic hair-washing experience.", "Russia", "8"));
        arrayList.add(new ModelClass(R.drawable.t1, "Garnier's shampoos focus on the power of fruits and botanicals for healthy and vibrant hair.", "U.S.A", "8"));
        arrayList.add(new ModelClass(R.drawable.t6, "Pantene is known for its Pro-V formula, offering healthy and shiny hair.", "U.A.E", "9"));
        arrayList.add(new ModelClass(R.drawable.t5, "Head & Shoulders is a trusted brand for dandruff control, ensuring a healthy scalp.", "Qatar", "8"));
        arrayList.add(new ModelClass(R.drawable.t4, "Dove's shampoos provide nourishment and moisture, leaving hair soft and manageable.", "Pakistan", "8"));
        arrayList.add(new ModelClass(R.drawable.t3, "L'Oréal Paris offers advanced formulas and luxurious results for various hair concerns.", "Canida", "8"));
        arrayList.add(new ModelClass(R.drawable.t2, "Herbal Essences infuses natural ingredients for a refreshing and aromatic hair-washing experience.", "Austarila", "8"));
        arrayList.add(new ModelClass(R.drawable.t1, "Garnier's shampoos focus on the power of fruits and botanicals for healthy and vibrant hair.", "England", "8"));
        arrayList.add(new ModelClass(R.drawable.t6, "Paul Mitchell offers a wide range of salon-quality products for all hair types and needs.", "France", "8"));


        adapter=new CustomAdapter(MainActivity.this,arrayList,this);


        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onItemClicked(ModelClass modelClass) {
       Intent i=new Intent(MainActivity.this, ProductInfo.class);
       i.putExtra("product_name",modelClass.NameP);
       i.putExtra("image_data",modelClass.flagImg);
       i.putExtra("desciptionProduct",modelClass.Description);
       i.putExtra("remainingProduct",modelClass.RemaingP);
       startActivity(i);
    }
}