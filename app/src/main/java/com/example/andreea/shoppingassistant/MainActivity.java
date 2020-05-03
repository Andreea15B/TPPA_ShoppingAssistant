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

    TextView textName, textCategory, textAmount;
    ArrayList<Product> products = new ArrayList<>();
    ListView products_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textName);
        textCategory = findViewById(R.id.textCategory);
        textAmount = findViewById(R.id.textAmount);
        products_list = findViewById(R.id.productsList);

        Product p = new Product("ProductName_default", "ProductCategory_default", 10);
        products.add(p);

        // Create the adapter to convert the array to views
        ProductAdapter adapter = new ProductAdapter(this, products);
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
