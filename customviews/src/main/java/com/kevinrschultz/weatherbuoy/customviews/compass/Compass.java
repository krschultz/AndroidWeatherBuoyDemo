package com.kevinrschultz.weatherbuoy.customviews.compass;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public interface Compass {

    /**
     * @param waveDirection 0 to 360 degrees
     */
    public void setWaveDirection(double waveDirection);

    /**
     * @param windDirection 0 to 360 degrees
     */
    public void setWindDirection(double windDirection);


}
