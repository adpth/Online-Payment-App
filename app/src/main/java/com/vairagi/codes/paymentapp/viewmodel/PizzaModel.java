package com.vairagi.codes.paymentapp.viewmodel;

import android.graphics.drawable.Drawable;

public class PizzaModel {

    private String item;
    private String price;
    private int image;

    public PizzaModel(String item, String price, int image) {
        this.item = item;
        this.price = price;
        this.image = image;
    }

    public String getItem() {
        return item;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

}
