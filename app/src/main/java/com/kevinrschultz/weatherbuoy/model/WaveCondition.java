package com.kevinrschultz.weatherbuoy.model;

import com.google.common.base.Objects;

/**
 * @author Kevin Schultz
 */
public class WaveCondition {

    private static final String TAG = WaveCondition.class.getSimpleName();

    private final double waveHeight;

    private final double averageWavePeriod;

    private final int meanWaveDirection;

    public WaveCondition(double waveHeight, int dominantWavePeriod, int meanWaveDirection) {
        this.waveHeight = waveHeight;
        this.averageWavePeriod = dominantWavePeriod;
        this.meanWaveDirection = meanWaveDirection;
    }

    public double getWaveHeight() {
        return waveHeight;
    }

    public double getAverageWavePeriod() {
        return averageWavePeriod;
    }

    public int getMeanWaveDirection() {
        return meanWaveDirection;
    }

    /**
     * Object methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        boolean equal = false;
        if (o instanceof WaveCondition) {
            WaveCondition other = (WaveCondition) o;
            equal = Objects.equal(this.waveHeight, other.waveHeight) &&
                    Objects.equal(this.averageWavePeriod, other.averageWavePeriod) &&
                    Objects.equal(this.meanWaveDirection, other.meanWaveDirection);
        }

        return equal;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TAG)
                .add("wave height", waveHeight)
                .add("wave period", averageWavePeriod)
                .add("wave direction", meanWaveDirection)
                .toString();
    }

}
