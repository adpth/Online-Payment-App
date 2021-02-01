package com.vairagi.codes.paymentapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vairagi.codes.paymentapp.MainActivity;
import com.vairagi.codes.paymentapp.R;
import com.vairagi.codes.paymentapp.viewmodel.BurgerModel;
import com.vairagi.codes.paymentapp.viewmodel.PizzaModel;

import java.util.ArrayList;

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder> {

    ArrayList<BurgerModel> model;
    Context context;

    public BurgerAdapter(ArrayList<BurgerModel> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_layout,parent,false);
        return new BurgerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgerViewHolder holder, int position) {
        BurgerModel modelList = model.get(position);

        holder.rate.setText(modelList.getPrice());
        holder.textView.setText(modelList.getItem());
        holder.imageView.setImageResource(modelList.getImage());
        holder.itemView.setOnClickListener((View v) -> {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            intent.putExtra("BurgerRate",modelList.getPrice());
            v.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class BurgerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,rate;

        public BurgerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_icon);
            textView = itemView.findViewById(R.id.item_name);
            rate = itemView.findViewById(R.id.item_price);
        }
    }

}