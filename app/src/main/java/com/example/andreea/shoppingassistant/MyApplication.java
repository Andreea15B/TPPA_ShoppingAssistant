package com.example.andreea.shoppingassistant;

import android.app.Application;

import java.util.List;

public class MyApplication extends Application {
    private List<Product> data;

    public void storeData(List<Product> data) {
        this.data = data;
    }

    public List<Product> getData() {
        return data;
    }
}
