package it.spassador.bluetime.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.R;

public class ChallengeActivity extends ActionBarActivity {
    ImageView mImageViewHeader, mImageViewChallenge1, mImageViewChallenge2, mImageViewChallenge3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        mImageViewHeader = (ImageView) findViewById(R.id.challenge_header);
        mImageViewChallenge1 = (ImageView) findViewById(R.id.challenge_1);
        mImageViewChallenge2 = (ImageView) findViewById(R.id.challenge_2);
        mImageViewChallenge3 = (ImageView) findViewById(R.id.challenge_3);

        mImageViewHeader.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.icon_tabs, 200, 200));
        mImageViewChallenge1.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.friends_profile1, 200, 200));
        mImageViewChallenge2.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.friends_profile2, 200, 200));
        mImageViewChallenge3.setImageBitmap(CommonUtilities.decodeSampledBitmapFromResource(getApplicationContext().getResources(), R.drawable.friends_profile3, 200, 200));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge, menu);
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
}
