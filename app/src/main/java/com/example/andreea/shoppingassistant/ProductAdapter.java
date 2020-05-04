package com.example.andreea.shoppingassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_details_layout, parent, false);
        }

        // Lookup view for data population
        TextView textName = convertView.findViewById(R.id.textName);
        TextView textCategory = convertView.findViewById(R.id.textCategory);
        TextView textAmount = convertView.findViewById(R.id.textAmount);

        // Populate the data into the template view using the data object
        textName.setText(product.getName());
        textCategory.setText(product.getCategory());
        textAmount.setText(Integer.toString(product.getAmount()));

        // Return the completed view to render on screen
        return convertView;
    }
}
