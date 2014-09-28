package com.kevinrschultz.weatherbuoy.sandbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
* @author Kevin Schultz (kschultz@gilt.com)
*/
public class ActivityLaunchingListItem {

    private final String displayName;
    private final Class<? extends Activity> activityClass;

    public ActivityLaunchingListItem(String displayName, Class<? extends Activity> activityClass) {
        this.displayName = displayName;
        this.activityClass = activityClass;
    }

    public Intent getIntent(Context context) {
        return new Intent(context, activityClass);
    }

    @Override
    public String toString() {
        return displayName;
    }
}
