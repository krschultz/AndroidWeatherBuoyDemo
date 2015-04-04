package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class BaseFragment extends Fragment {

    protected View onCreateViewWithButterKnife(@LayoutRes int layout, LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(layout, container, false);
        ButterKnife.inject(this, v);
        return v;
    }
}
