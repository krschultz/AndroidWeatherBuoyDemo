package com.kevinrschultz.weatherbuoy.views;

public interface Instrument {

    void setLabel(String label);

    void updateReading(String value, String units);

}
