package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.util.UnitConverter;

/**
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

    public int getWindDirection() {
        return wind.getDirection();
    }

    public double getWindSpeed() {
        UnitSystem units = preferences.getUserUnitSystem();
        switch(units) {
            case IMPERIAL:
                return UnitConverter.kphToMph(UnitConverter.knotsToKph(wind.getSpeed()));
            case METRIC:
                return UnitConverter.knotsToKph(wind.getSpeed());
            case NAUTICAL:
            default:
                return wind.getSpeed();
        }
    }

    public int getWaveDirection() {
        return wave.getDirection();
    }

    public double getWavePeriod() {
        return wave.getPeriod();
    }

    public double getWaveHeight() {
        UnitSystem units = preferences.getUserUnitSystem();
        switch(units) {
            case METRIC:
                return UnitConverter.feetToMeters(wave.getHeight());
            case IMPERIAL:
            case NAUTICAL:
            default:
                return wave.getHeight();
        }
    }
}
