package com.kevinrschultz.weatherbuoy.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kevinrschultz.weatherbuoy.R;


public class BuoyDetailActivity extends BaseActivity {

    public static Intent makeBuoyDetailIntent(Context context) {
        return new Intent(context, BuoyDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        attachBuoyDetailFragment();
    }

    private void attachBuoyDetailFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.activity_fragment_container, BuoyDetailFragment.makeBuoyDetailFragment());
        ft.commit();
    }

}
