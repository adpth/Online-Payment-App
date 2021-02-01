package com.vairagi.codes.paymentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.vairagi.codes.paymentapp.Adapter.PaymentOptionAdapter;
import com.vairagi.codes.paymentapp.viewmodel.PaymentData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiveData();
        loadData();

    }

    private void receiveData() {

        TextView textView = findViewById(R.id.rate);

        String Burger = getIntent().getStringExtra("BurgerRate");
        String drink = getIntent().getStringExtra("DrinkRate");
        String pizza = getIntent().getStringExtra("PizzaRate");
        if (Burger!=null) {
            price = Burger;
        }
        else if(drink!=null) {
            price = drink;
        }
        else if(pizza!=null ) {
            price = pizza;
        }
        textView.setText(price);
    }

    private void loadData() {
        ArrayList<PaymentData> paymentData = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.paymentOptionRecyclerView);

        paymentData.add(new PaymentData("PhonePay",R.drawable.phonepay));
        paymentData.add(new PaymentData("GooglePay",R.drawable.googlepay));
        paymentData.add(new PaymentData("Paytm",R.drawable.paytm));
        paymentData.add(new PaymentData("AmazonPay",R.drawable.amazonpay));

        //LayoutManager For RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PaymentOptionAdapter paymentOptionAdapter = new PaymentOptionAdapter(price,paymentData,this);
        recyclerView.setAdapter(paymentOptionAdapter);
    }
}