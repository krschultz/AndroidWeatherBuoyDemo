package com.kevinrschultz.weatherbuoy.model;

import com.google.common.base.Objects;

public class BuoyDescription {

    private static final String TAG = BuoyDescription.class.getSimpleName();

    private int id;

    private String name;

    public BuoyDescription(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Object methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        boolean equal = false;
        if (o instanceof BuoyDescription) {
            BuoyDescription other = (BuoyDescription) o;
            equal = Objects.equal(this.id, other.id) &&
                    Objects.equal(this.name, other.name);
        }

        return equal;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TAG)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
