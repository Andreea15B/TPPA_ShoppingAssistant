package com.example.andreea.shoppingassistant;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayStores extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stores_layout);

        populateStores();
    }

    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ListView stores_list;

    public void populateStores() {

        MyLocation g = new MyLocation(getApplicationContext());
        Location loc = g.getLocation();

        Product p1 = new Product("Milk", "Diary", 10);
        Product p2 = new Product("Bread", "Bread & Cereal", 20);
        Product p3 = new Product("Cheese", "Diary", 15);
        Product p4 = new Product("Chocolate", "Snacks", 20);
        Product p5 = new Product("Chips", "Snacks", 20);
        products.add(p1); products.add(p2); products.add(p3); products.add(p4); products.add(p5);

        Random randomizer = new Random();
        Store s1 = new Store("Kaufland", products, loc, randomizer);
        products.clear();

        p1 = new Product("Bread", "Bread & Cereal", 40);
        products.add(p1);
        randomizer.setSeed(System.currentTimeMillis());
        Store s2 = new Store("Penny Market", products, loc, randomizer);
        products.clear();

        p1 = new Product("Pasta", "Pasta & Rice", 1);
        products.add(p1);
        randomizer.setSeed(System.currentTimeMillis());
        Store s3 = new Store("Auchan", products, loc, randomizer);
        products.clear();

        p1 = new Product("Milk", "Diary", 10);
        p2 = new Product("Bread", "Bread & Cereal", 20);
        products.add(p1); products.add(p2);
        randomizer.setSeed(System.currentTimeMillis());
        Store s4 = new Store("Selgros", products, loc, randomizer);
        products.clear();

        stores.add(s1); stores.add(s2); stores.add(s3); stores.add(s4);

        stores_list = findViewById(R.id.storesList);
        StoresAdapter adapter = new StoresAdapter(this, stores);
        stores_list.setAdapter(adapter);
    }

    public void showProductsForStore(View view) {
        // TO DO
    }
}
