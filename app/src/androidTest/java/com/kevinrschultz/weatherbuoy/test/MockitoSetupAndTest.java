package com.kevinrschultz.weatherbuoy.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * {@link https://code.google.com/p/dexmaker/issues/detail?id=2}
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class MockitoSetupAndTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("dexmaker.dexcache", InstrumentationRegistry.getTargetContext().getCacheDir().getPath());
    }

    @Test
    public void testMockito() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

}
