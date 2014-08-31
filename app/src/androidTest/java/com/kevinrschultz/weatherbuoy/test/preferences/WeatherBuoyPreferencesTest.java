package com.kevinrschultz.weatherbuoy.test.preferences;

import android.test.InstrumentationTestCase;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class WeatherBuoyPreferencesTest extends InstrumentationTestCase {

    private WeatherBuoyPreferences preferences;

    @Override
    public void setUp() {
        preferences = new WeatherBuoyPreferences(getInstrumentation().getTargetContext());
        preferences.clearUserPreferences();
    }

    public void testGetUserUnitSystem_Nautical() {
        preferences.setUserUnitSystem(UnitSystem.NAUTICAL);
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

    public void testGetUserUnitSystem_Metric() {
        preferences.setUserUnitSystem(UnitSystem.METRIC);
        assertEquals(UnitSystem.METRIC, preferences.getUserUnitSystem());
    }

    public void testGetUserUnitSystem_Imperial() {
        preferences.setUserUnitSystem(UnitSystem.IMPERIAL);
        assertEquals(UnitSystem.IMPERIAL, preferences.getUserUnitSystem());
    }

    public void testGetUserUnitSystem_Default() {
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

    public void testClearUserPreferences() {
        preferences.setUserUnitSystem(UnitSystem.IMPERIAL);
        preferences.clearUserPreferences();
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

}