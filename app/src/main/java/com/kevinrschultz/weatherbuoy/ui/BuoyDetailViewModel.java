package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.views.Compass;
import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.util.UnitConverter;
import com.kevinrschultz.weatherbuoy.views.Instrument;

/**
 * ViewModel to handle formatting
 *
 * Depends on two data models and user preferences
 *
 * Does not hold a reference to the view
 *
 * @author Kevin Schultz
 */
public class BuoyDetailViewModel {

    private final WindCondition wind;

    private final WaveCondition wave;

    private final WeatherBuoyPreferences preferences;

    public BuoyDetailViewModel(WindCondition wind, WaveCondition wave, WeatherBuoyPreferences preferences) {
        this.wind = wind;
        this.wave = wave;
        this.preferences = preferences;
    }

    public void updateWindDirection(Instrument windDirectionView, Compass compass) {
        windDirectionView.updateReading(Integer.toString(wind.getDirection()), "");
        compass.setWindDirection(wind.getDirection());
    }

    public void updateWaveDirection(Compass compass) {
        int direction = wave.getDirection();
        compass.setWaveDirection(direction);
    }

    public void updateWindSpeed(Instrument windSpeedView) {
        UnitSystem unitSystem = preferences.getUserUnitSystem();
        double speed;
        String unitString;
        switch(unitSystem) {
            case IMPERIAL:
                speed = UnitConverter.kphToMph(UnitConverter.knotsToKph(wind.getSpeed()));
                unitString = "mph";
                break;
            case METRIC:
                speed = UnitConverter.knotsToKph(wind.getSpeed());
                unitString = "kph";
                break;
            case NAUTICAL:
            default:
                speed = wind.getSpeed();
                unitString = "kts";
                break;
        }
        windSpeedView.updateReading(String.format("%.1f", speed), unitString);
    }

    public void updateWavePeriod(Instrument wavePeriodView) {
        wavePeriodView.updateReading(String.format("%.1f", wave.getPeriod()), "s");
    }

    public void updateWaveHeight(Instrument waveHeightView) {
        UnitSystem unitSystem = preferences.getUserUnitSystem();
        double height;
        String unitString;
        switch(unitSystem) {
            case METRIC:
                height = UnitConverter.feetToMeters(wave.getHeight());
                unitString = "m";
                break;
            case IMPERIAL:
            case NAUTICAL:
            default:
                height = wave.getHeight();
                unitString = "ft";
                break;
        }
        waveHeightView.updateReading(String.format("%.1f", height), unitString);
    }

}
