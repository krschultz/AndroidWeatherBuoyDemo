package com.kevinrschultz.weatherbuoy.test.preferences;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class WeatherBuoyPreferencesTest {

    private WeatherBuoyPreferences preferences;

    @Before
    public void setUp() {
        preferences = new WeatherBuoyPreferences(InstrumentationRegistry.getTargetContext());
        preferences.clearUserPreferences();
    }

    @Test
    public void testGetUserUnitSystem_Nautical() {
        preferences.setUserUnitSystem(UnitSystem.NAUTICAL);
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

    @Test
    public void testGetUserUnitSystem_Metric() {
        preferences.setUserUnitSystem(UnitSystem.METRIC);
        assertEquals(UnitSystem.METRIC, preferences.getUserUnitSystem());
    }

    @Test
    public void testGetUserUnitSystem_Imperial() {
        preferences.setUserUnitSystem(UnitSystem.IMPERIAL);
        assertEquals(UnitSystem.IMPERIAL, preferences.getUserUnitSystem());
    }

    @Test
    public void testGetUserUnitSystem_Default() {
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

    @Test
    public void testClearUserPreferences() {
        preferences.setUserUnitSystem(UnitSystem.IMPERIAL);
        preferences.clearUserPreferences();
        assertEquals(UnitSystem.NAUTICAL, preferences.getUserUnitSystem());
    }

}