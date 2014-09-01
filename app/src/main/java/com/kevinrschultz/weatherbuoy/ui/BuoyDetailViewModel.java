package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.util.UnitConverter;
import com.kevinrschultz.weatherbuoy.views.Instrument;

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

    public void updateWindDirection(Instrument windDirectionView) {
        windDirectionView.updateReading(Integer.toString(wind.getDirection()), "");
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

        String value = String.format("%.1f", speed);
        windSpeedView.updateReading(value, unitString);
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
