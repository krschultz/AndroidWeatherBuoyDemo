package com.kevinrschultz.weatherbuoy.test.util;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.kevinrschultz.weatherbuoy.util.UnitConverter;

import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Kevin Schultz
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class UnitConverterTest {

    private static final Offset<Double> PRECISION = Offset.offset(0.01);

    @Test
    public void testKnotsToKph() {
        assertThat(UnitConverter.knotsToKph(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.knotsToKph(1.00)).isCloseTo(1.85, PRECISION);
        assertThat(UnitConverter.knotsToKph(5.00)).isCloseTo(9.26, PRECISION);
        assertThat(UnitConverter.knotsToKph(10.00)).isCloseTo(18.52, PRECISION);
        assertThat(UnitConverter.knotsToKph(15.00)).isCloseTo(27.78, PRECISION);
        assertThat(UnitConverter.knotsToKph(20.00)).isCloseTo(37.04, PRECISION);
    }

    @Test
    public void testMphToKph() {
        assertThat(UnitConverter.mphToKph(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.mphToKph(1.00)).isCloseTo(1.61, PRECISION);
        assertThat(UnitConverter.mphToKph(5.00)).isCloseTo(8.05, PRECISION);
        assertThat(UnitConverter.mphToKph(10.00)).isCloseTo(16.10, PRECISION);
        assertThat(UnitConverter.mphToKph(15.00)).isCloseTo(24.14, PRECISION);
        assertThat(UnitConverter.mphToKph(20.00)).isCloseTo(32.19, PRECISION);
    }

    @Test
    public void testKphToKnots() {
        assertThat(UnitConverter.kphToKnots(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.kphToKnots(1.00)).isCloseTo(0.54, PRECISION);
        assertThat(UnitConverter.kphToKnots(10.00)).isCloseTo(5.40, PRECISION);
        assertThat(UnitConverter.kphToKnots(20.00)).isCloseTo(10.80, PRECISION);
        assertThat(UnitConverter.kphToKnots(40.00)).isCloseTo(21.60, PRECISION);
    }

    @Test
    public void testKphToMph() {
        assertThat(UnitConverter.kphToMph(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.kphToMph(1.00)).isCloseTo(0.62, PRECISION);
        assertThat(UnitConverter.kphToMph(10.00)).isCloseTo(6.21, PRECISION);
        assertThat(UnitConverter.kphToMph(20.00)).isCloseTo(12.43, PRECISION);
        assertThat(UnitConverter.kphToMph(40.00)).isCloseTo(24.85, PRECISION);
    }

    @Test
    public void testFeetToMeters() {
        assertThat(UnitConverter.feetToMeters(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.feetToMeters(1.00)).isCloseTo(0.30, PRECISION);
        assertThat(UnitConverter.feetToMeters(5.00)).isCloseTo(1.52, PRECISION);
        assertThat(UnitConverter.feetToMeters(10.00)).isCloseTo(3.05, PRECISION);
    }

    @Test
    public void testMetersToFeet() {
        assertThat(UnitConverter.metersToFeet(0.00)).isEqualTo(0.00);
        assertThat(UnitConverter.metersToFeet(1.00)).isCloseTo(3.28, PRECISION);
        assertThat(UnitConverter.metersToFeet(5.00)).isCloseTo(16.40, PRECISION);
        assertThat(UnitConverter.metersToFeet(10.00)).isCloseTo(32.80, PRECISION);
    }
}
