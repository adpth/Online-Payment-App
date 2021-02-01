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
import com.vairagi.codes.paymentapp.viewmodel.DrinkModel;
import com.vairagi.codes.paymentapp.viewmodel.PizzaModel;

import java.util.ArrayList;

public class CooldrinkAdapter extends RecyclerView.Adapter<CooldrinkAdapter.CooldrinkViewHolder> {

    ArrayList<DrinkModel> model;
    Context context;

    public CooldrinkAdapter(ArrayList<DrinkModel> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public CooldrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_layout,parent,false);
        return new CooldrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CooldrinkViewHolder holder, int position) {
        DrinkModel modelList = model.get(position);

        holder.rate.setText(modelList.getPrice());
        holder.textView.setText(modelList.getItem());
        holder.imageView.setImageResource(modelList.getImage());
        holder.itemView.setOnClickListener((View v) -> {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            intent.putExtra("DrinkRate",modelList.getPrice());
            v.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public static class CooldrinkViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,rate;


        public CooldrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_icon);
            textView = itemView.findViewById(R.id.item_name);
            rate = itemView.findViewById(R.id.item_price);
        }
    }
}
