package com.kevinrschultz.weatherbuoy.test.models;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.Advisory;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author Kevin Schultz
 */
public class AdvisoryTest extends TestCase {

    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/advisory.json");
        Advisory parsed = GsonSingleton.get().fromJson(json, Advisory.class);
        Advisory expected = new Advisory("test");
        assertEquals(expected, parsed);
    }


}
