package com.vairagi.codes.paymentapp.Adapter;

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
import com.vairagi.codes.paymentapp.R;
import com.vairagi.codes.paymentapp.viewmodel.PaymentData;

import java.util.ArrayList;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionViewHolder>
        implements PaymentStatusListener {

    ArrayList<PaymentData> paymentData;
    Context context;
    String price;

    public PaymentOptionAdapter(String price, ArrayList<PaymentData> paymentData, Context context) {
        this.paymentData = paymentData;
        this.context = context;
        this.price = price;
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

       holder.imageView.setImageResource(currentData.getPaymentOptionImage());
       holder.itemView.setOnClickListener(view -> {
           switch (currentData.getPaymentOptionName()) {
               case "PhonePay":
                   try {
                       String transactionId = "TID" + System.currentTimeMillis();

                       // START PAYMENT INITIALIZATION
                       EasyUpiPayment.Builder builder = new EasyUpiPayment.Builder((Activity) context)
                               .with(PaymentApp.PHONE_PE)
                               .setPayeeVpa("Your PhonePay id")
                               .setPayeeName("Your Name")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("Merchant Code")
                               .setDescription("description")
                               .setAmount(price.concat(".00"));
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
                               .setPayeeVpa("Your GooglePay id")
                               .setPayeeName("Your Name")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("Merchant Code")
                               .setDescription("description")
                               .setAmount(price.concat(".00"));
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
                               .setPayeeVpa("Your Paytm ID")
                               .setPayeeName("Your Name")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("Merchant Code")
                               .setDescription("description")
                               .setAmount(price.concat(".00"));
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
                               .setPayeeVpa("Your AmazonPay ID")
                               .setPayeeName("Your Name")
                               .setTransactionId(transactionId)
                               .setTransactionRefId(transactionId)
                               .setPayeeMerchantCode("Merchant Code")
                               .setDescription("description")
                               .setAmount(price.concat(".00"));
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
