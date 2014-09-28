package com.kevinrschultz.weatherbuoy.sandbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kevinrschultz.weatherbuoy.customviews.compass.CompassView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class CompassViewActivity extends Activity {

    @InjectView(R.id.compass_compass)
    CompassView compass;

    @InjectView(R.id.compass_wave_seekbar)
    SeekBar waveSeekBar;

    @InjectView(R.id.compass_wind_seekbar)
    SeekBar windSeekBar;

    @InjectView(R.id.compass_wave_label)
    TextView waveLabel;

    @InjectView(R.id.compass_wind_label)
    TextView windLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass_view);
        ButterKnife.inject(this);

        waveSeekBar.setOnSeekBarChangeListener(makeWaveSeekBarListener());
        windSeekBar.setOnSeekBarChangeListener(makeWindSeekBarListener());

    }

    private SeekBar.OnSeekBarChangeListener makeWaveSeekBarListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double direction = getDirectionFromProgress(progress);
                waveLabel.setText(String.format("%.1f", direction));
                compass.setWaveDirection(direction);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };
    }

    private SeekBar.OnSeekBarChangeListener makeWindSeekBarListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double direction = getDirectionFromProgress(progress);
                windLabel.setText(String.format("%.1f", direction));
                compass.setWindDirection(direction);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };
    }

    private double getDirectionFromProgress(int progress) {
        return (360.0 * (double) progress) / 100.0;
    }

}
