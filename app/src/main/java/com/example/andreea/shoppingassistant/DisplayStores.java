package com.example.andreea.shoppingassistant;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.andreea.shoppingassistant.MyApplication.stores;

public class DisplayStores extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stores_layout);

        populateStores();
    }

    public void populateStores() {
        ListView stores_list = findViewById(R.id.storesList);
        StoresAdapter adapter = new StoresAdapter(this, stores);
        stores_list.setAdapter(adapter);
    }

    public void showProductsForStore(View view) {
        // TO DO
    }
}
