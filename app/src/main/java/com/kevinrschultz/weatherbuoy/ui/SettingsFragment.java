package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;

/**
 */
public class SettingsFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    
    private WeatherBuoyPreferences preferences;

    private RadioGroup unitSystemRadioGroup;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public SettingsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.preferences = new WeatherBuoyPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        unitSystemRadioGroup = (RadioGroup) v.findViewById(R.id.settings_unit_system);
        unitSystemRadioGroup.setOnCheckedChangeListener(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        setCurrentChecked(preferences.getUserUnitSystem());
    }

    public void setCurrentChecked(UnitSystem system) {
        switch(system) {
            case IMPERIAL:
                ((RadioButton) getView().findViewById(R.id.settings_radio_imperial)).setChecked(true);
                break;
            case METRIC:
                ((RadioButton) getView().findViewById(R.id.settings_radio_metric)).setChecked(true);
                break;
            case NAUTICAL:
                ((RadioButton) getView().findViewById(R.id.settings_radio_nautical)).setChecked(true);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.settings_unit_system:
                updateUnitSystemPreference(checkedId);
                break;
        }
    }

    private void updateUnitSystemPreference(int checkedId) {
        switch(checkedId) {
            case R.id.settings_radio_imperial:
                preferences.setUserUnitSystem(UnitSystem.IMPERIAL);
                break;
            case R.id.settings_radio_metric:
                preferences.setUserUnitSystem(UnitSystem.METRIC);
                break;
            case R.id.settings_radio_nautical:
                preferences.setUserUnitSystem(UnitSystem.NAUTICAL);
                break;
        }
    }

    /**
     * For test dependency injection
     */
    private void setPreferences(WeatherBuoyPreferences preferences) {
        this.preferences = preferences;
    }
}
