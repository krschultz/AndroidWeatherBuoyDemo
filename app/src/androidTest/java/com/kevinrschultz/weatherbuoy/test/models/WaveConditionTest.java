package com.kevinrschultz.weatherbuoy.test.models;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @see com.kevinrschultz.weatherbuoy.model.WaveCondition
 */
public class WaveConditionTest extends TestCase {

    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/wave.json");
        WaveCondition parsed = GsonSingleton.get().fromJson(json, WaveCondition.class);
        WaveCondition expected = new WaveCondition(4.3, 6.7, 103);
        assertEquals(expected, parsed);
    }
}
