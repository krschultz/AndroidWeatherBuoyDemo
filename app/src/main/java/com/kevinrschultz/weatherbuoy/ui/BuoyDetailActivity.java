package com.kevinrschultz.weatherbuoy.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kevinrschultz.weatherbuoy.R;


public class BuoyDetailActivity extends BaseActivity {

    private static final String TAG = BuoyDetailActivity.class.getSimpleName();

    public static Intent makeBuoyDetailIntent(Context context, int bouyId) {
        return new Intent(context, BuoyDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            attachBuoyDetailFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = SettingsActivity.makeSettingsActivityIntent(this);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void attachBuoyDetailFragment() {
        attachFragment(BuoyDetailFragment.makeBuoyDetailFragment(), TAG, false);
    }

}
