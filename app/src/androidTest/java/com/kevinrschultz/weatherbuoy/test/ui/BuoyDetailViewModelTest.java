package com.kevinrschultz.weatherbuoy.test.ui;

import com.kevinrschultz.weatherbuoy.model.UnitSystem;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.ui.BuoyDetailViewModel;
import com.kevinrschultz.weatherbuoy.views.Instrument;

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
    private static final int WIND_DIRECTION = 90;
    private static final WindCondition WIND_CONDTIONS = new WindCondition(SPEED, WIND_DIRECTION);

    private static final double HEIGHT = 5.0;
    private static final double PERIOD = 8.1;
    private static final int WAVE_DIRECTION = 225;
    private static final WaveCondition WAVE_CONDITION = new WaveCondition(HEIGHT, PERIOD, WAVE_DIRECTION);

    private MockInstrument mockInstrument;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mockInstrument = new MockInstrument();
    }

    public void testGetWindDirection() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        viewModel.updateWindDirection(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("90");
        assertThat(mockInstrument.units).isEqualTo("");
    }

    public void testGetWindSpeed_Imperial() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeImperialPreferences());
        viewModel.updateWindSpeed(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("11.5");
        assertThat(mockInstrument.units).isEqualTo("mph");
    }

    public void testGetWindSpeed_Metric() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeMetricPreferences());
        viewModel.updateWindSpeed(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("18.5");
        assertThat(mockInstrument.units).isEqualTo("kph");
    }

    public void testGetWindSpeed_Nautical() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        viewModel.updateWindSpeed(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("10.0");
        assertThat(mockInstrument.units).isEqualTo("kts");
    }

    public void testGetWaveDirection() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        assertThat(viewModel.getWaveDirection()).isEqualTo(WAVE_CONDITION.getDirection());
    }

    public void testGetWavePeriod() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        viewModel.updateWavePeriod(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("8.1");
        assertThat(mockInstrument.units).isEqualTo("s");
    }

    public void testGetWaveHeight_Imperial() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeImperialPreferences());
        viewModel.updateWaveHeight(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("5.0");
        assertThat(mockInstrument.units).isEqualTo("ft");
    }

    public void testGetWaveHeight_Metric() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeMetricPreferences());
        viewModel.updateWaveHeight(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("1.5");
        assertThat(mockInstrument.units).isEqualTo("m");
    }

    public void testGetWaveHeight_Nautical() {
        BuoyDetailViewModel viewModel = new BuoyDetailViewModel(WIND_CONDTIONS, WAVE_CONDITION, makeNauticalPreferences());
        viewModel.updateWaveHeight(mockInstrument);
        assertThat(mockInstrument.value).isEqualTo("5.0");
        assertThat(mockInstrument.units).isEqualTo("ft");
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

    private class MockInstrument implements Instrument {
        public String label;
        public String value;
        public String units;

        @Override
        public void setLabel(String label) {
            this.label = label;
        }

        @Override
        public void updateReading(String value, String units) {
            this.value = value;
            this.units = units;
        }
    }

}
