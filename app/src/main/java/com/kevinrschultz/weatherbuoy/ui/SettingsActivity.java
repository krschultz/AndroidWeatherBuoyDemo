package com.kevinrschultz.weatherbuoy.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kevinrschultz.weatherbuoy.R;

public class SettingsActivity extends Activity {

    public static Intent makeSettingsActivityIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.activity_fragment_container, SettingsFragment.newInstance())
                    .commit();
        }
    }

}
