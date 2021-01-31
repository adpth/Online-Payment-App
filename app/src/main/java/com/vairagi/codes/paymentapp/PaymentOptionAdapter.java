package com.vairagi.codes.paymentapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shreyaspatil.easyupipayment.EasyUpiPayment;
import com.shreyaspatil.easyupipayment.exception.AppNotFoundException;
import com.shreyaspatil.easyupipayment.listener.PaymentStatusListener;
import com.shreyaspatil.easyupipayment.model.PaymentApp;
import com.shreyaspatil.easyupipayment.model.TransactionDetails;

import java.util.ArrayList;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionViewHolder> implements PaymentStatusListener {

    ArrayList<PaymentData> paymentData;
    Context context;

    public PaymentOptionAdapter(ArrayList<PaymentData> paymentData, Context context) {
        this.paymentData = paymentData;
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.payment_options_list,parent,false);
        return new PaymentOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionViewHolder holder, int position) {
       PaymentData currentData = paymentData.get(position);

       holder.textView.setText(currentData.getPaymentOptionName());
       holder.imageView.setImageResource(currentData.getPaymentOptionImage());

       holder.itemView.setOnClickListener(view -> {
           switch (currentData.getPaymentOptionName()) {
               case "PhonePay":


                   try {
                       String transactionId = "TID" + System.currentTimeMillis();

                       // START PAYMENT INITIALIZATION
                       EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder((Activity) context)
                               .with(PaymentApp.PHONE_PE)
                               .setPayeeVpa("9727367829@apl")
                               .setPayeeName("Darsh monani")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("12345")
                               .setDescription("drscroption")
                               .setAmount("10.00");
                       EasyUpiPayment easyUpiPayment = builder.build();
                       easyUpiPayment.startPayment();
                   } catch (AppNotFoundException e) {
                       e.printStackTrace();
                   }
                   break;
               case "GooglePay":
                   try {
                       String transactionId = "TID" + System.currentTimeMillis();

                       // START PAYMENT INITIALIZATION
                       EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder((Activity) context)
                               .with(PaymentApp.GOOGLE_PAY)
                               .setPayeeVpa("9727367829@apl")
                               .setPayeeName("Darsh monani")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("12345")
                               .setDescription("drscroption")
                               .setAmount("10.00");
                       EasyUpiPayment easyUpiPayment = builder.build();
                       easyUpiPayment.startPayment();
                   } catch (AppNotFoundException e) {
                       e.printStackTrace();
                   }
                   break;

               case "Paytm":
                   try {
                       String transactionId = "TID" + System.currentTimeMillis();

                       // START PAYMENT INITIALIZATION
                       EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder((Activity) context)
                               .with(PaymentApp.PAYTM)
                               .setPayeeVpa("9727367829@apl")
                               .setPayeeName("Darsh monani")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("12345")
                               .setDescription("drscroption")
                               .setAmount("10.00");
                       EasyUpiPayment easyUpiPayment = builder.build();
                       easyUpiPayment.startPayment();
                   } catch (AppNotFoundException e) {
                       e.printStackTrace();
                   }
                   break;

               case "AmazonPay":
                   try {
                       String transactionId = "TID" + System.currentTimeMillis();

                       // START PAYMENT INITIALIZATION
                       EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder((Activity) context)
                               .with(PaymentApp.AMAZON_PAY)
                               .setPayeeVpa("9727367829@apl")
                               .setPayeeName("Darsh monani")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("12345")
                               .setDescription("drscroption")
                               .setAmount("10.00");
                       EasyUpiPayment easyUpiPayment = builder.build();
                       easyUpiPayment.startPayment();
                   } catch (AppNotFoundException e) {
                       e.printStackTrace();
                   }
                   break;

           }
       });

    }

    @Override
    public int getItemCount() {
        return paymentData.size();
    }

    @Override
    public void onTransactionCancelled() {

    }

    @Override
    public void onTransactionCompleted(TransactionDetails transactionDetails) {
        Toast.makeText(context,"Paid",Toast.LENGTH_LONG).show();
    }

    public static class PaymentOptionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public PaymentOptionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.appsIcon);
            textView = itemView.findViewById(R.id.appsTitle);
        }
    }
}
