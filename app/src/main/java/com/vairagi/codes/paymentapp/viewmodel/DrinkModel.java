package com.vairagi.codes.paymentapp.viewmodel;

public class DrinkModel {

    private String item;
    private String price;
    private int image;

    public DrinkModel(String item, String price, int image) {
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
