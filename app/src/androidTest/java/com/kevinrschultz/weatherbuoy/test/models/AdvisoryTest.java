package com.kevinrschultz.weatherbuoy.test.models;

import android.text.TextUtils;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.Advisory;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @see com.kevinrschultz.weatherbuoy.model.Advisory
 */
public class AdvisoryTest extends TestCase {

    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/advisory.json");
        Advisory parsed = GsonSingleton.get().fromJson(json, Advisory.class);
        Advisory expected = new Advisory("test");
        assertEquals(expected, parsed);
    }

    public void testToString() {
        assertFalse(TextUtils.isEmpty(new Advisory("test").toString()));
    }

    public void testEquals() {
        Advisory a = new Advisory("test");
        Advisory b = new Advisory("test");
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }

}
