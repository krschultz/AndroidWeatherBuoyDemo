package com.kevinrschultz.weatherbuoy.model;

import com.google.common.base.Objects;

/**
 * @author Kevin Schultz
 */
public class WindCondition {

    private static final String TAG = WindCondition.class.getSimpleName();

    private final double speed;

    private final int direction;

    /**
     * GSON Constructor
     */
    public WindCondition() {
        this.speed = 0.0;
        this.direction = 0;
    }

    /**
     * @param speed
     * @param direction
     */
    public WindCondition(double speed, int direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
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
        if (o instanceof WindCondition) {
            WindCondition other = (WindCondition) o;
            equal = Objects.equal(this.speed, other.speed) &&
                    Objects.equal(this.direction, other.direction);
        }

        return equal;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TAG)
                .add("speed", speed)
                .add("direction", direction)
                .toString();
    }
}
