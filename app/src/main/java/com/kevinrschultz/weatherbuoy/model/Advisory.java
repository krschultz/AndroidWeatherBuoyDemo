package com.kevinrschultz.weatherbuoy.model;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/**
 * @author Kevin Schultz
 */
public class Advisory {
    
    private static final String TAG = Advisory.class.getSimpleName();

    private String advisory;

    public Advisory(String advisory) {
        this.advisory = advisory;
    }

    public Optional<String> getAdvisory() {
        return Optional.fromNullable(advisory);
    }

    /**
     * Object methods
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        boolean equal = false;
        if (o instanceof Advisory) {
            Advisory other = (Advisory) o;
            equal = Objects.equal(this.advisory, other.advisory);
        }

        return equal;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TAG)
                .add("advisory", advisory)
                .toString();
    }
}
