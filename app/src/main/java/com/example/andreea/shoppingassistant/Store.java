package com.example.andreea.shoppingassistant;

import android.location.Location;
import android.provider.Settings;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Store {
    public String name;
    public ArrayList<Product> products_in_store;
    public Location location;
    private Random randomizer;

    Store(String name, ArrayList<Product> products_in_store, Location location, Random randomizer) {
        this.name = name;
        this.products_in_store = products_in_store;
        this.location = new Location(location);

        this.randomizer = randomizer;

        int randomValue = randomizer.nextInt(90);
        this.location.setLatitude(location.getLatitude() + randomValue);
        this.location.setLongitude(location.getLongitude() + randomValue);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts_in_store() {
        return products_in_store;
    }

    public String getLatitude() {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(location.getLatitude());
    }

    public String getLongitude() {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(location.getLongitude());
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", products_in_store=" + products_in_store +
                ", location=" + location +
                '}';
    }
}