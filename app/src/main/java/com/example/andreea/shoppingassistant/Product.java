package com.example.andreea.shoppingassistant;

public class Product {
    public String name, category;
    public int amount;
    Product(String name, String category, int amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Product {" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}
