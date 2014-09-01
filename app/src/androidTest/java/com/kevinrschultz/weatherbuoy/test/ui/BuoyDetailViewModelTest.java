package com.kevinrschultz.weatherbuoy.test.ui;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.ui.BuoyDetailViewModel;

import junit.framework.TestCase;

import org.assertj.core.data.Offset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @see com.kevinrschultz.weatherbuoy.ui.BuoyDetailViewModel
 */
public class BuoyDetailViewModelTest extends TestCase {

    private static final Offset<Double> PRECISION = Offset.offset(0.01);

    private static final double SPEED = 10.0;
    private static final int WIND_DIRECTION = 125;
    private static final WindCondition WIND_CONDTIONS = new WindCondition(SPEED, WIND_DIRECTION);

    private static final double HEIGHT = 5.0;
    private static final int PERIOD = 8;
    private static final int WAVE_DIRECTION = 225;
    private static final WaveCondition WAVE_CONDITION = new WaveCondition(HEIGHT, PERIOD, WAVE_DIRECTION);

    public void testGetWindDirection() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWindDirection()).isEqualTo(WIND_CONDTIONS.getDirection());
    }

    public void testGetWindSpeed_Imperial() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeImperialPreferences());
        assertThat(viewModel.getWindSpeed()).isCloseTo(11.51, PRECISION);
    }

    public void testGetWindSpeed_Metric() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeMetricPreferences());
        assertThat(viewModel.getWindSpeed()).isCloseTo(18.52, PRECISION);
    }

    public void testGetWindSpeed_Nautical() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWindSpeed()).isCloseTo(SPEED, PRECISION);
    }

    public void testGetWaveDirection() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWaveDirection()).isEqualTo(WAVE_CONDITION.getDirection());
    }

    public void testGetWavePeriod() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWavePeriod()).isEqualTo(WAVE_CONDITION.getPeriod());
    }

    public void testGetWaveHeight_Imperial() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeImperialPreferences());
        assertThat(viewModel.getWaveHeight()).isCloseTo(HEIGHT, PRECISION);
    }

    public void testGetWaveHeight_Metric() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeMetricPreferences());
        assertThat(viewModel.getWaveHeight()).isCloseTo(1.52, PRECISION);
    }

    public void testGetWaveHeight_Nautical() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWaveHeight()).isCloseTo(HEIGHT, PRECISION);
    }

    private WeatherBuoyPreferences makeImperialPreferences() {
        WeatherBuoyPreferences mockPreferences = mock(WeatherBuoyPreferences.class);
        when(mockPreferences.getUserUnitSystem()).thenReturn(UnitSystem.IMPERIAL);
        return mockPreferences;
    }

    private WeatherBuoyPreferences makeMetricPreferences() {
        WeatherBuoyPreferences mockPreferences = mock(WeatherBuoyPreferences.class);
        when(mockPreferences.getUserUnitSystem()).thenReturn(UnitSystem.METRIC);
        return mockPreferences;
    }

    private WeatherBuoyPreferences makeNauticalPreferences() {
        WeatherBuoyPreferences mockPreferences = mock(WeatherBuoyPreferences.class);
        when(mockPreferences.getUserUnitSystem()).thenReturn(UnitSystem.NAUTICAL);
        return mockPreferences;
    }

}
