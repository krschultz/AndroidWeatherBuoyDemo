package com.kevinrschultz.weatherbuoy.test.ui;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.kevinrschultz.weatherbuoy.data.FakeBuoyListingGenerator;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;
import com.kevinrschultz.weatherbuoy.model.Region;
import com.kevinrschultz.weatherbuoy.ui.BuoyListingPresenter;
import com.kevinrschultz.weatherbuoy.ui.BuoyListingView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class BuoyListingPresenterTest {

    private BuoyListingPresenter defaultPresenter;

    @Before
    public void setUp() throws Exception {
        defaultPresenter = new BuoyListingPresenter();
    }

    @Test
    public void testSetView() {
        BuoyListingView view = mock(BuoyListingView.class);
        defaultPresenter.setView(view);
        verify(view).updateList(anyListOf(BuoyDescription.class));
    }

    @Test
    public void testClearView() {
        BuoyListingView view = mock(BuoyListingView.class);
        defaultPresenter.setView(view);
        verify(view).updateList(anyListOf(BuoyDescription.class));
        defaultPresenter.clearView();
        defaultPresenter.selectRegion(Region.ATLANTIC);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testSelectRegion_Atlantic() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.ATLANTIC);
        assertEquals(FakeBuoyListingGenerator.makeAtlanticBuoyListings(), view.descriptionList);
    }

    @Test
    public void testSelectRegion_Pacific() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.PACIFIC);
        assertEquals(FakeBuoyListingGenerator.makePacificBuoyListings(), view.descriptionList);
    }

    @Test
    public void testSelectRegion_Caribbean() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.CARIBBEAN);
        assertEquals(FakeBuoyListingGenerator.makeCaribbeanBuoyListings(), view.descriptionList);
    }

    @Test
    public void testSelectRegion_None() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(null);
        assertEquals(FakeBuoyListingGenerator.makeAtlanticBuoyListings(), view.descriptionList);
    }

    private static class MockBuoyListingView implements BuoyListingView {

        public List<BuoyDescription> descriptionList;

        @Override
        public void updateList(List<BuoyDescription> descriptionList) {
            this.descriptionList = descriptionList;
        }
    }
}
