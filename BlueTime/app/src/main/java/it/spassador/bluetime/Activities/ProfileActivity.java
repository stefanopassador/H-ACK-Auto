package it.spassador.bluetime.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.R;

public class ProfileActivity extends ActionBarActivity {
    ImageView profile1, profile2, profile3, profile4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile1 = (ImageView) findViewById(R.id.profile_1);
        profile2 = (ImageView) findViewById(R.id.profile_2);
        profile3 = (ImageView) findViewById(R.id.profile_3);
        profile4 = (ImageView) findViewById(R.id.profile_4);

        int width = 200;
        int height = 200;
        profile1.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.profile_1, width, height));
        profile2.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.profile_2, width, height));
        profile3.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.profile_3, width, height));
        profile4.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.profile_4, width, height));

        profile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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
