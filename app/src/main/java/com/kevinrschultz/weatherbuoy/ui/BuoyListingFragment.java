package com.kevinrschultz.weatherbuoy.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BuoyListingFragment extends Fragment implements BuoyListingView, AdapterView.OnItemClickListener {

    private BuoyListingPresenter presenter;

    private BuoyDescriptionAdapter adapter;

    private ListView listView;

    public static BuoyListingFragment makeBuoyListingFragment() {
        return new BuoyListingFragment();
    }

    public BuoyListingFragment() {
        presenter = new BuoyListingPresenter();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buoy_listing, container, false);
        listView = ListView.class.cast(v.findViewById(android.R.id.list));
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BuoyDescriptionAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
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
        BuoyDescription description = adapter.getItem(position);
        Intent intent = BuoyDetailActivity.makeBuoyDetailIntent(getActivity(), description.getId());
        startActivity(intent);
    }

    @Override
    public void updateList(List<BuoyDescription> descriptionList) {
        adapter.clear();
        adapter.addAll(descriptionList);
    }


}
