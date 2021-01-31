package com.vairagi.codes.paymentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PatternMatcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PaymentData> paymentData;
    PaymentOptionAdapter paymentOptionAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paymentData = new ArrayList<>();
        recyclerView = findViewById(R.id.paymentOptionRecyclerView);

        paymentData.add(new PaymentData("PhonePay",R.drawable.phonepay));
        paymentData.add(new PaymentData("GooglePay",R.drawable.googlepay));
        paymentData.add(new PaymentData("Paytm",R.drawable.paytm));
        paymentData.add(new PaymentData("AmazonPay",R.drawable.amazonpay));

        //LayoutManager For RecyclerView
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        paymentOptionAdapter = new PaymentOptionAdapter(paymentData,this);
        recyclerView.setAdapter(paymentOptionAdapter);
    }
}