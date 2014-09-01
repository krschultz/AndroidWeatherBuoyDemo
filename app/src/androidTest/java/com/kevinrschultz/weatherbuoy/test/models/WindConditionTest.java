package com.kevinrschultz.weatherbuoy.test.models;

import android.text.TextUtils;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @see com.kevinrschultz.weatherbuoy.model.WindCondition
 */
public class WindConditionTest extends TestCase {

    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/wind.json");
        WindCondition parsed = GsonSingleton.get().fromJson(json, WindCondition.class);
        WindCondition expected = new WindCondition(10.6, 108);
        assertEquals(expected, parsed);
    }

    public void testToString() {
        assertFalse(TextUtils.isEmpty(new WindCondition(10.6, 108).toString()));
    }

    public void testEquals() {
        WindCondition a = new WindCondition(10.6, 108);
        WindCondition b = new WindCondition(10.6, 108);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
