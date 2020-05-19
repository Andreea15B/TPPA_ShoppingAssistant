package com.example.andreea.shoppingassistant;

public class Product {
    public String name, category;
    public int amount;
    boolean checked;

    Product(String name, String category, int amount, boolean checked) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.checked = checked;
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
