package com.kevinrschultz.weatherbuoy.sandbox;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private final ActivityLaunchingListItem[] listItems = {
            new ActivityLaunchingListItem("Compass View", CompassViewActivity.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<ActivityLaunchingListItem> adapter = new ArrayAdapter<ActivityLaunchingListItem>(
                this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ActivityLaunchingListItem item = (ActivityLaunchingListItem) getListAdapter().getItem(position);
        startActivity(item.getIntent(this));
    }

}
