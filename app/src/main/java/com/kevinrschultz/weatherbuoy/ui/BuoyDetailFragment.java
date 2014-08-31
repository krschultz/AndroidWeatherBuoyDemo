package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.Advisory;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class BuoyDetailFragment extends Fragment {

    private AdvisoryBannerView advisoryBanner;

    public static BuoyDetailFragment newInstance() {
        return new BuoyDetailFragment();
    }

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
    }

    private void loadData() {
        loadMockData.execute();
    }

    private AsyncTask<Void, Void, Void> loadMockData = new AsyncTask<Void, Void, Void>() {

        @Override
        protected Void doInBackground(Void... params) {
            // Network call or something like that here
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
                Advisory advisory = new Advisory("Mock advisory");
                WindCondition wind = new WindCondition(12.3, 103);
                WaveCondition wave = new WaveCondition(4.3, 8.2, 204);
            }
        }
    };
}
