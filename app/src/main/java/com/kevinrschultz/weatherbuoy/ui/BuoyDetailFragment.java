package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.customviews.compass.CompassView;
import com.kevinrschultz.weatherbuoy.model.Advisory;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.preferences.WeatherBuoyPreferences;
import com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView;
import com.kevinrschultz.weatherbuoy.views.InstrumentView;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class BuoyDetailFragment extends Fragment {

    // Models
    private Advisory advisory;
    private WaveCondition waves;
    private WindCondition wind;

    // View Model
    private BuoyDetailViewModel viewModel;

    // Views
    private AdvisoryBannerView advisoryBanner;
    private InstrumentView windSpeedView;
    private InstrumentView windDirectionView;
    private InstrumentView waveHeightView;
    private InstrumentView wavePeriodView;
    private CompassView compassView;

    public static BuoyDetailFragment makeBuoyDetailFragment() {
        return new BuoyDetailFragment();
    }

    public BuoyDetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buoy_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViews();
        loadData();
    }

    private void findViews() {
        final View v = getView();
        advisoryBanner = AdvisoryBannerView.class.cast(v.findViewById(R.id.buoy_detail_banner));
        windSpeedView = InstrumentView.class.cast(v.findViewById(R.id.buoy_detail_wind_speed));
        windDirectionView = InstrumentView.class.cast(v.findViewById(R.id.buoy_detail_wind_direction));
        waveHeightView = InstrumentView.class.cast(v.findViewById(R.id.buoy_detail_wave_height));
        wavePeriodView = InstrumentView.class.cast(v.findViewById(R.id.buoy_detail_wave_period));
        compassView = CompassView.class.cast(v.findViewById(R.id.buoy_detail_compass));
    }

    private void loadData() {
        loadMockAdvisory.execute();
        loadMockInstruments.execute();
    }

    private void updateAdvisory(Advisory advisory) {
        this.advisory = advisory;
        advisoryBanner.setOptionalText(advisory.getAdvisory());
    }

    private void updateInstruments(WindCondition windCondition, WaveCondition waveCondition) {
        this.wind = windCondition;
        this.waves = waveCondition;
        this.viewModel = new BuoyDetailViewModel(wind, waves, new WeatherBuoyPreferences(getActivity()));
        viewModel.updateWindSpeed(windSpeedView);
        viewModel.updateWindDirection(windDirectionView, compassView);
        viewModel.updateWaveDirection(compassView);
        viewModel.updateWaveHeight(waveHeightView);
        viewModel.updateWavePeriod(wavePeriodView);
    }

    private AsyncTask<Void, Void, Void> loadMockAdvisory = new AsyncTask<Void, Void, Void>() {

        @Override
        protected Void doInBackground(Void... params) {
            // Simulate network call or loading from disk
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(getActivity() != null) {
                advisory = new Advisory("SMALL CRAFT ADVISORY REMAINS IN EFFECT UNTIL 11 PM EDT THIS EVENING");
                updateAdvisory(advisory);
            }
        }
    };

    private AsyncTask<Void, Void, Void> loadMockInstruments = new AsyncTask<Void, Void, Void>() {

        @Override
        protected Void doInBackground(Void... params) {
            // Simulate network call or loading from disk
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(getActivity() != null) {
                WindCondition randomWind = new WindCondition(Math.random() * 25.0, (int) (Math.random() * 360.0));
                WaveCondition randomWave = new WaveCondition(Math.random() * 10.0, 6.0 + Math.random() * 8.0, (int) Math.random() * 360);
                updateInstruments(randomWind, randomWave);
            }
        }
    };

}
