package com.kevinrschultz.weatherbuoy.test.models;


import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
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
 * @see com.kevinrschultz.weatherbuoy.model.WindCondition
 */
@RunWith(JUnit4.class)
public class WindConditionTest {

    @Test
    public void testJsonParsing() throws IOException {
        String json = ResourceUtils.getStringFromResourceFile("/fixtures/wind.json");
        WindCondition parsed = GsonSingleton.get().fromJson(json, WindCondition.class);
        WindCondition expected = new WindCondition(10.6, 108);
        assertEquals(expected, parsed);
    }

    @Test
    public void testToString() {
        assertNotNull(new WindCondition(10.6, 108).toString());
    }

    @Test
    public void testEquals() {
        WindCondition a = new WindCondition(10.6, 108);
        WindCondition b = new WindCondition(10.6, 108);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
