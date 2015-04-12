package it.spassador.bluetime.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.airbnb.android.airmapview.AirMapMarker;
import com.airbnb.android.airmapview.AirMapView;
import com.airbnb.android.airmapview.listeners.OnMapInitializedListener;
import com.airbnb.android.airmapview.listeners.OnMapMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

import it.spassador.bluetime.Database.DatabaseAdapter;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.Task;
import it.spassador.bluetime.TDA.Todo;
import it.spassador.bluetime.TDA.TodoTask;


public class MapsActivity extends ActionBarActivity {
    AirMapView mapView;
    Location location;
    ArrayList<TodoTask> arrayList;
    Activity mActivity;
    boolean canZoom = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mActivity = this;
        mapView = (AirMapView) findViewById(R.id.map_view);
        try {
            mapView.initialize(getSupportFragmentManager());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.setOnMapInitializedListener(new OnMapInitializedListener() {
            @Override
            public void onMapInitialized() {
                showMarker();
            }
        });

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location loc) {
                if (canZoom) {
                    location = loc;
                    mapView.animateCenterZoom(new LatLng(location.getLatitude(), location.getLongitude()), 11);
                    canZoom = false;
                }
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
        });

        mapView.setOnMarkerClickListener(new OnMapMarkerClickListener() {
            @Override
            public void onMapMarkerClick(long l) {

            }

            @Override
            public void onMapMarkerClick(Marker marker) {
                final Marker m = marker;
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                builder.setMessage(marker.getTitle())
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + m.getPosition().latitude + "," + m.getPosition().longitude));
                                startActivity(i);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
            }
        });

        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        db.open();
        Cursor cursor = db.fetchAllTodo();
        arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(new Todo(cursor));
        }
        cursor.close();
        cursor = db.fetchAllTask();
        while (cursor.moveToNext()) {
            arrayList.add(new Task(cursor));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maps, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void showMarker() {
        for (TodoTask t : arrayList) {
            mapView.addMarker(new AirMapMarker(new LatLng(t.getLatitude(), t.getLongitude()), 1)
                    .setTitle(t.getTitle() + " | " + t.getDescription())
                    .setIconId(t instanceof Todo ? R.drawable.icon_location_pin_green : R.drawable.icon_location_pin_blue)
                    .setId(t.getId()));
        }
    }
}
