package com.vairagi.codes.paymentapp;

public class PaymentData {
    private String paymentOptionName;
    private int paymentOptionImage;

    public PaymentData(String paymentOptionName, int paymentOptionImage) {
        this.paymentOptionName = paymentOptionName;
        this.paymentOptionImage = paymentOptionImage;
    }

    public String getPaymentOptionName() {
        return paymentOptionName;
    }

    public int getPaymentOptionImage() {
        return paymentOptionImage;
    }
}
