package com.kevinrschultz.weatherbuoy.ui;

import android.os.Bundle;

import com.kevinrschultz.weatherbuoy.R;

public class BuoyListingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        if (savedInstanceState == null) {
            attachBuoyListingFragment();
        }
    }

    private void attachBuoyListingFragment() {
        getFragmentManager().beginTransaction()
                .add(R.id.activity_fragment_container, BuoyListingFragment.makeBuoyListingFragment())
                .commit();
    }

}
