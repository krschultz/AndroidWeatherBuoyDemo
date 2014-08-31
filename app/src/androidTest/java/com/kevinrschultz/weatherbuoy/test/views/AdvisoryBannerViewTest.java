package com.kevinrschultz.weatherbuoy.test.views;

import android.test.AndroidTestCase;

import com.google.common.base.Optional;
import com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView;

import static org.assertj.android.api.Assertions.assertThat;

/**
 * @see com.kevinrschultz.weatherbuoy.views.AdvisoryBannerView
 */
public class AdvisoryBannerViewTest extends AndroidTestCase {

    private AdvisoryBannerView advisoryBannerView;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        advisoryBannerView = new AdvisoryBannerView(getContext());
    }

    public void testSetOptionalText_shows() {
        Optional<String> optionalText = Optional.fromNullable("test");
        advisoryBannerView.setOptionalText(optionalText);
        assertThat(advisoryBannerView).isVisible();
    }

    public void testSetOptionalText_hidesWhenAbsent() {
        Optional<String> absentText = Optional.absent();
        advisoryBannerView.setOptionalText(absentText);
        assertThat(advisoryBannerView).isGone();
    }

    public void testSetOptionalText_hidesWhenEmptyString() {
        Optional<String> emptyString = Optional.fromNullable("");
        advisoryBannerView.setOptionalText(emptyString);
        assertThat(advisoryBannerView).isGone();
    }
}
