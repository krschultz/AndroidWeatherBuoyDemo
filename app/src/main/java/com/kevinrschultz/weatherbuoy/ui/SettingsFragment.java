package com.kevinrschultz.weatherbuoy.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;

import butterknife.InjectView;

public class SettingsFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    private WeatherBuoyPreferences preferences;

    // Views
    @InjectView(R.id.settings_unit_system)
    RadioGroup unitSystemRadioGroup;
    @InjectView(R.id.settings_radio_imperial)
    RadioButton imperialButton;
    @InjectView(R.id.settings_radio_metric)
    RadioButton metricButton;
    @InjectView(R.id.settings_radio_nautical)
    RadioButton nauticalButton;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public SettingsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.preferences = new WeatherBuoyPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateViewWithButterKnife(R.layout.fragment_settings, inflater, container);
        unitSystemRadioGroup.setOnCheckedChangeListener(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        setCurrentChecked(preferences.getUserUnitSystem());
    }

    public void setCurrentChecked(UnitSystem system) {
        switch (system) {
            case IMPERIAL:
                imperialButton.setChecked(true);
                break;
            case METRIC:
                metricButton.setChecked(true);
                break;
            case NAUTICAL:
                nauticalButton.setChecked(true);
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
        switch (checkedId) {
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
