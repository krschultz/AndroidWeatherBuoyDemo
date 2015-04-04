package com.kevinrschultz.weatherbuoy.ui;

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

import butterknife.InjectView;

/**
 * A placeholder fragment containing a simple view.
 */
public class BuoyListingFragment extends BaseFragment implements
        BuoyListingView,
        AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    private BuoyListingPresenter presenter;

    private BuoyDescriptionAdapter buoyAdapter;

    private ArrayAdapter<Region> regionAdapter;

    // Views
    @InjectView(android.R.id.list)
    ListView buoyListView;
    @InjectView(R.id.buoy_listing_region_spinner)
    Spinner regionSpinner;

    public static BuoyListingFragment makeBuoyListingFragment() {
        return new BuoyListingFragment();
    }

    public BuoyListingFragment() {
        presenter = new BuoyListingPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateViewWithButterKnife(R.layout.fragment_buoy_listing, inflater, container);
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
