package com.kevinrschultz.weatherbuoy.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SettingsActivity extends BaseActivity {

    private static final String TAG = SettingsActivity.class.getSimpleName();

    public static Intent makeSettingsActivityIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            attachSettingsFragment();
        }
    }

    private void attachSettingsFragment() {
        attachFragment(SettingsFragment.newInstance(), TAG, false);
    }

}
