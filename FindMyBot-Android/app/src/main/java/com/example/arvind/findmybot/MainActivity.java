package com.example.arvind.findmybot;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class MainActivity extends AppCompatActivity {

    private final long UPDATE_INTERVAL = 2000;
    private final long FASTEST_UPDATE_INTERVAL = UPDATE_INTERVAL / 2;
    private TextView latitudeText, longitudeText, timeText;
    private String latitudes, longitudes, times;
    private int count = 0;
    private long time = System.currentTimeMillis();
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Toast.makeText(this, "We're live!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

        // Remove the User by name, once the user exits the App - Assumed that user has left the room
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(R.layout.login_dialog_layout)
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(false)
                .setTitle("Welcome");

        AlertDialog dialog = builder.create();
        dialog.show();


        Button callBotButton = findViewById(R.id.call);
        callBotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0.5f, new android.location.LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                time = System.currentTimeMillis() - time;
                latitudes = String.valueOf(location.getLatitude());
                longitudes = String.valueOf(location.getLongitude());
                Toast.makeText(MainActivity.this, "" + latitudes + ", " + longitudes, Toast.LENGTH_LONG).show();
                time = System.currentTimeMillis();
                        // TODO: Create a POST request, and send the updated Lat and Long values
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                }, new Handler().getLooper());
            }
        });

        LocationRequest request = new LocationRequest();
        request.setInterval(UPDATE_INTERVAL);
        request.setFastestInterval(FASTEST_UPDATE_INTERVAL);
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//        latitudeText = findViewById(R.id.latitude_text);
//        longitudeText = findViewById(R.id.longitude_text);
//        timeText = findViewById(R.id.time);
    }
}
