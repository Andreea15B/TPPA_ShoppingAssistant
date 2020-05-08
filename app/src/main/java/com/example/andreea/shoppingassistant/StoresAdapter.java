package com.example.andreea.shoppingassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StoresAdapter extends ArrayAdapter<Store> {
    public StoresAdapter(Context context, ArrayList<Store> stores) {
        super(context, 0, stores);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Store store = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stores_details_layout, parent, false);

        // Lookup view for data population
        TextView textName = convertView.findViewById(R.id.textName);
        TextView textLatitude = convertView.findViewById(R.id.textLatitude);
        TextView textLongitude = convertView.findViewById(R.id.textLongitude);

        // Populate the data into the template view using the data object
        textName.setText(store.getName());
        textLatitude.setText(store.getLatitude());
        textLongitude.setText(store.getLongitude());

        // Return the completed view to render on screen
        return convertView;
    }
}
