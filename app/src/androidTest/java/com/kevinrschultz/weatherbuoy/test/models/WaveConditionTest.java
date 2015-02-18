package com.kevinrschultz.weatherbuoy.test.models;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.TextUtils;

import com.kevinrschultz.weatherbuoy.json.GsonSingleton;
import com.kevinrschultz.weatherbuoy.model.WaveCondition;
import com.kevinrschultz.weatherbuoy.test.TestUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see com.kevinrschultz.weatherbuoy.model.WaveCondition
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class WaveConditionTest {

    @Test
    public void testJsonParsing() throws IOException {
        String json = TestUtils.getStringFromResourceFile("fixtures/wave.json");
        WaveCondition parsed = GsonSingleton.get().fromJson(json, WaveCondition.class);
        WaveCondition expected = new WaveCondition(4.3, 6.7, 103);
        assertEquals(expected, parsed);
    }

    @Test
    public void testToString() {
        assertFalse(TextUtils.isEmpty(new WaveCondition(4.3, 6.7, 103).toString()));
    }

    @Test
    public void testEquals() {
        WaveCondition a = new WaveCondition(4.3, 6.7, 103);
        WaveCondition b = new WaveCondition(4.3, 6.7, 103);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
