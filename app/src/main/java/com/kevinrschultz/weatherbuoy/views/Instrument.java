package com.kevinrschultz.weatherbuoy.views;

/**
 * @author Kevin Schultz
 */
public interface Instrument {

    public void setLabel(String label);

    public void updateReading(String value, String units);

}
