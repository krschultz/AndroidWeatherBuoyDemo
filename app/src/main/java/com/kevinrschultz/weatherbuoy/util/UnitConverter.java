package com.kevinrschultz.weatherbuoy.util;

public final class UnitConverter {

    private UnitConverter() {
    }

    public static double knotsToKph(double knots) {
        return knots * 1.8520;
    }

    public static double mphToKph(double mph) {
        return mph * 1.60934;
    }

    public static double kphToKnots(double kph) {
        return kph * 0.539957;
    }

    public static double kphToMph(double kph) {
        return kph * 0.621371;
    }

    public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static double metersToFeet(double meters) {
        return meters * 3.28;
    }
}
