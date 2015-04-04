package com.kevinrschultz.weatherbuoy.views;

public interface Compass {

    /**
     * @param waveDirection 0 to 360 degrees
     */
    void setWaveDirection(double waveDirection);

    /**
     * @param windDirection 0 to 360 degrees
     */
    void setWindDirection(double windDirection);

}