package com.kevinrschultz.weatherbuoy.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * @author Kevin Schultz
 */
public class WaveCondition {

    private static final String TAG = WaveCondition.class.getSimpleName();

    private final double height;

    @SerializedName("avg_period")
    private final double period;

    private final int direction;

    /**
     * GSON Constructor
     */
    public WaveCondition() {
        this.height = 0.0;
        this.period = 0.0;
        this.direction = 0;
    }

    /**
     * @param height
     * @param period
     * @param direction
     */
    public WaveCondition(double height, double period, int direction) {
        this.height = height;
        this.period = period;
        this.direction = direction;
    }

    public double getHeight() {
        return height;
    }

    public double getPeriod() {
        return period;
    }

    public int getDirection() {
        return direction;
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
            equal = Objects.equal(this.height, other.height) &&
                    Objects.equal(this.period, other.period) &&
                    Objects.equal(this.direction, other.direction);
        }

        return equal;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TAG)
                .add("wave height", height)
                .add("wave period", period)
                .add("wave direction", direction)
                .toString();
    }

}
