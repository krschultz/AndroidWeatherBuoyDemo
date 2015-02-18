package com.kevinrschultz.weatherbuoy.test.models;


import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.Advisory;
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
 * @see com.kevinrschultz.weatherbuoy.model.Advisory
 */
@RunWith(JUnit4.class)
public class AdvisoryTest {

    @Test
    public void testJsonParsing() throws IOException {
        String json = ResourceUtils.getStringFromResourceFile("fixtures/advisory.json");
        Advisory parsed = GsonSingleton.get().fromJson(json, Advisory.class);
        Advisory expected = new Advisory("test");
        assertEquals(expected, parsed);
    }

    @Test
    public void testToString() {
        assertNotNull(new Advisory("test").toString());
    }

    @Test
    public void testEquals() {
        Advisory a = new Advisory("test");
        Advisory b = new Advisory("test");
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }

}
