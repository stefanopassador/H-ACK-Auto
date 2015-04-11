package it.spassador.bluetime;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.airbnb.android.airmapview.AirMapMarker;
import com.airbnb.android.airmapview.AirMapView;
import com.google.android.gms.maps.model.LatLng;


public class MapsActivity extends ActionBarActivity {
    AirMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = (AirMapView) findViewById(R.id.map_view);
        try {
            mapView.initialize(getSupportFragmentManager());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Need small icon
        // Need that the map is initialized
        mapView.addMarker(new AirMapMarker(new LatLng(45.434561, 12.339712d), 1)
                .setTitle("San Marco, Venezia")
                .setIconId(R.drawable.icon_location_pin));
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
