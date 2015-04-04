package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;
import com.kevinrschultz.weatherbuoy.model.Region;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BuoyListingFragment extends Fragment implements BuoyListingView, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private BuoyListingPresenter presenter;

    private BuoyDescriptionAdapter buoyAdapter;

    private ArrayAdapter<Region> regionAdapter;

    private ListView buoyListView;

    private Spinner regionSpinner;

    public static BuoyListingFragment makeBuoyListingFragment() {
        return new BuoyListingFragment();
    }

    public BuoyListingFragment() {
        presenter = new BuoyListingPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buoy_listing, container, false);
        buoyListView = ListView.class.cast(v.findViewById(android.R.id.list));
        regionSpinner = Spinner.class.cast(v.findViewById(R.id.buoy_listing_region_spinner));
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buoyAdapter = new BuoyDescriptionAdapter(getActivity());
        buoyListView.setAdapter(buoyAdapter);
        buoyListView.setOnItemClickListener(this);
        regionAdapter = makeRegionAdapter();
        regionSpinner.setAdapter(regionAdapter);
        regionSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.clearView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == buoyListView) {
            BuoyDescription description = buoyAdapter.getItem(position);
            Intent intent = BuoyDetailActivity.makeBuoyDetailIntent(getActivity(), description.getId());
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == regionSpinner) {
            presenter.selectRegion(regionAdapter.getItem(position));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if (parent == regionSpinner) {
            presenter.selectRegion(null);
        }
    }

    @Override
    public void updateList(List<BuoyDescription> descriptionList) {
        buoyAdapter.clear();
        buoyAdapter.addAll(descriptionList);
    }

    private ArrayAdapter<Region> makeRegionAdapter() {
        ArrayAdapter<Region> adapter = new ArrayAdapter<Region>(getActivity(), android.R.layout.simple_expandable_list_item_1, Region.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

}
