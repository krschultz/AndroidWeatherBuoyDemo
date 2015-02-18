package com.kevinrschultz.weatherbuoy.test.models;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.TextUtils;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WindCondition;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see com.kevinrschultz.weatherbuoy.model.WindCondition
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class WindConditionTest {

    @Test
    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/wind.json");
        WindCondition parsed = GsonSingleton.get().fromJson(json, WindCondition.class);
        WindCondition expected = new WindCondition(10.6, 108);
        assertEquals(expected, parsed);
    }

    @Test
    public void testToString() {
        assertFalse(TextUtils.isEmpty(new WindCondition(10.6, 108).toString()));
    }

    @Test
    public void testEquals() {
        WindCondition a = new WindCondition(10.6, 108);
        WindCondition b = new WindCondition(10.6, 108);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
