package com.kevinrschultz.weatherbuoy.test.views;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import com.google.common.base.Optional;
import com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.android.api.Assertions.assertThat;

/**
 * @see com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class AdvisoryBannerViewTest {

    private AdvisoryBannerView advisoryBannerView;

    @Before
    public void setUp() throws Exception {
        advisoryBannerView = new AdvisoryBannerView(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void testSetOptionalText_shows() {
        Optional<String> optionalText = Optional.fromNullable("test");
        advisoryBannerView.setOptionalText(optionalText);
        assertThat(advisoryBannerView).isVisible();
    }

    @Test
    public void testSetOptionalText_hidesWhenAbsent() {
        Optional<String> absentText = Optional.absent();
        advisoryBannerView.setOptionalText(absentText);
        assertThat(advisoryBannerView).isGone();
    }

    @Test
    public void testSetOptionalText_hidesWhenEmptyString() {
        Optional<String> emptyString = Optional.fromNullable("");
        advisoryBannerView.setOptionalText(emptyString);
        assertThat(advisoryBannerView).isGone();
    }
}
