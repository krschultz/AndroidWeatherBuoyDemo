package com.kevinrschultz.weatherbuoy.sandbox;

import android.app.Activity;
import android.os.Bundle;

import com.kevinrschultz.weatherbuoy.customviews.compass.Compass;


public class CompassViewActivity extends Activity {

    private Compass compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass_view);
    }

}
