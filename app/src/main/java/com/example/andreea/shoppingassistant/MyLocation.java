package com.example.andreea.shoppingassistant;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class MyLocation implements LocationListener {
    Context context;
    public MyLocation(Context c) {
        context = c;
    }

    public Location getLocation() {
        if(ContextCompat. checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission not granted!", Toast.LENGTH_LONG).show();
            return null;
        }

        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(isGPSEnabled) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
            Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;
        }
        else Toast.makeText(context, "Please enable GPS.", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        String msg = "New Latitude: "+latitude + "New Longitude: "+longitude;
        Log.i("locationChanged", msg);

        MainActivity mainActivity = MainActivity.getInstance();
        mainActivity.findNearStores(location);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onProviderDisabled(String provider) {}
}