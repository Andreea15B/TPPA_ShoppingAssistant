package com.example.andreea.shoppingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();
    ListView products_list;
    String[] categories = {"All", "Fruits & Vegetables", "Diary", "Beauty & Skincare", "Books", "Meat & Seafood", "Cleaning", "Beverages", "Pets", "Other", "Kids", "Bread & Cereal", "Condiments & Spices", "Baking", "Pasta & Rice", "Snacks", "Health", "Household"};
    ArrayAdapter<Product> adapter;

    private void initializeViews() {
        Spinner mySpinner = findViewById(R.id.btn_filter);
        mySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));

        products_list = findViewById(R.id.productsList);
        products_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products));

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position >= 0 && position < categories.length) {
                    getSelectedCategoryData(categories[position]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        products_list = findViewById(R.id.productsList);

        Product p = new Product("ProductName_default", "ProductCategory_default", 10);
        products.add(p);

        ProductAdapter adapter = new ProductAdapter(this, products);
        products_list.setAdapter(adapter);

    }

    private void getSelectedCategoryData(String category) {
        ArrayList<Product> products = new ArrayList<>();
        if (category == "All") {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        }
        else {
            for(Product product : products) {
                if(product.getCategory().equals(category)) {
                    products.add(product);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        }
        products_list.setAdapter(adapter);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        products = (ArrayList<Product>) ((MyApplication) getApplication()).getData();
        ProductAdapter adapter = new ProductAdapter(this, products);
        products_list.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyApplication) getApplication()).storeData(products);
    }

    public void addProduct(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.add_product, null);
        builder.setView(mView);
        builder.setTitle("Add new product");

        final EditText input_name = mView.findViewById(R.id.input_name);
        final Spinner input_category = mView.findViewById(R.id.input_type);
        final EditText input_amount = mView.findViewById(R.id.input_amount);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input_name.getText().toString();
                String category = input_category.getSelectedItem().toString();
                int amount = Integer.parseInt(input_amount.getText().toString());

                if(!name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You added: " + name + " " + category + " " + amount, Toast.LENGTH_LONG).show();
                    Product p = new Product(name, category, amount);
                    products.add(p);
                    ProductAdapter adapter = new ProductAdapter(MainActivity.this, products);
                    products_list.setAdapter(adapter);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
