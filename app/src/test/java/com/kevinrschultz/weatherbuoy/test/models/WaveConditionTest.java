package com.kevinrschultz.weatherbuoy.test.models;


import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.util.ResourceUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * @see com.kevinrschultz.weatherbuoy.model.WaveCondition
 */
@RunWith(JUnit4.class)
public class WaveConditionTest {

    @Test
    public void testJsonParsing() throws IOException {
        String json = ResourceUtils.getStringFromResourceFile("/fixtures/wave.json");
        WaveCondition parsed = GsonSingleton.get().fromJson(json, WaveCondition.class);
        WaveCondition expected = new WaveCondition(4.3, 6.7, 103);
        assertEquals(expected, parsed);
    }

    @Test
    public void testToString() {
        assertNotNull(new WaveCondition(4.3, 6.7, 103).toString());
    }

    @Test
    public void testEquals() {
        WaveCondition a = new WaveCondition(4.3, 6.7, 103);
        WaveCondition b = new WaveCondition(4.3, 6.7, 103);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
