package com.example.restaurantapplication.pojo;

public class Dish {

    private int mImageId;
    private String price;
    private String rating;
    private String name;

    public Dish(int mImageId, String price, String rating, String name) {
        this.mImageId = mImageId;
        this.price = price;
        this.rating = rating;
        this.name = name;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
}
