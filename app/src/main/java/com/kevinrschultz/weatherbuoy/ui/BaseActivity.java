package com.kevinrschultz.weatherbuoy.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.kevinrschultz.weatherbuoy.R;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
    }

    /**
     * @param f              - fragment
     * @param tag            - tag to find fragment by
     * @param addToBackStack - true if adding fragment should be in backstack, false if not
     */
    public void attachFragment(Fragment f, String tag, boolean addToBackStack) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.activity_fragment_container, f, tag);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

}
