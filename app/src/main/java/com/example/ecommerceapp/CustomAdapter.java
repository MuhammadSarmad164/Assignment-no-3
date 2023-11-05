package com.example.ecommerceapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    SelectListener selectListener;
    Context context;
    ArrayList<ModelClass> list;

    public CustomAdapter(Context context, ArrayList<ModelClass> list,SelectListener listener) {
        this.context = context;
        this.list = list;
        selectListener=listener;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ProductName,ProductDescription,ProductRemaining;
        ImageView ProductImage;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ProductImage=itemView.findViewById(R.id.imageProduct);
            ProductName=itemView.findViewById(R.id.productName);
            ProductDescription=itemView.findViewById(R.id.productDescription);
            ProductRemaining=itemView.findViewById(R.id.remainingProduct);
            constraintLayout=itemView.findViewById(R.id.constraintLayout);

        }



    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         ModelClass product=list.get(position);
         holder.ProductImage.setImageResource(product.flagImg);
         holder.ProductRemaining.setText(product.RemaingP);
         holder.ProductName.setText(product.NameP);
         holder.ProductDescription.setText(product.Description);
         holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 selectListener.onItemClicked(list.get(holder.getAdapterPosition()));
             }
         });



    }

    @Override
    public int getItemCount() {
        return list!=null? list.size() : 0;
    }
}
