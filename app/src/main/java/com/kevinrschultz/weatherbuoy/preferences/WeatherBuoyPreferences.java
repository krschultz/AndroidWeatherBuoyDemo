package com.kevinrschultz.weatherbuoy.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.kevinrschultz.weatherbuoy.Constants;
import com.kevinrschultz.weatherbuoy.model.UnitSystem;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class WeatherBuoyPreferences {

    private static final String PREFERENCES_FILE = "user_preferences";

    private static final String KEY_UNIT_SYSTEM = Constants.BUNDLE_KEY_ROOT + "unit_system";

    private final SharedPreferences preferences;

    public WeatherBuoyPreferences(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
    }

    public UnitSystem getUserUnitSystem() {
        String name = preferences.getString(KEY_UNIT_SYSTEM, "");
        return mapNameToUnitSystem(name);
    }

    public void setUserUnitSystem(UnitSystem preference) {
        preferences.edit().putString(KEY_UNIT_SYSTEM, preference.name()).apply();
    }

    public void clearUserPreferences() {
        preferences.edit().clear().apply();
    }

    private UnitSystem mapNameToUnitSystem(String name) {
        if(TextUtils.equals(name, "NAUTICAL")) {
            return UnitSystem.NAUTICAL;
        } else if (TextUtils.equals(name, "IMPERIAL")) {
            return UnitSystem.IMPERIAL;
        } else if (TextUtils.equals(name, "METRIC")) {
            return UnitSystem.METRIC;
        } else {
            return UnitSystem.NAUTICAL;
        }
    }
}
