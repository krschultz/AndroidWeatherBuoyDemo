package com.kevinrschultz.weatherbuoy.test.ui;

import com.kevinrschultz.weatherbuoy.data.FakeBuoyListingGenerator;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;
import com.kevinrschultz.weatherbuoy.model.Region;
import com.kevinrschultz.weatherbuoy.ui.BuoyListingPresenter;
import com.kevinrschultz.weatherbuoy.ui.BuoyListingView;

import junit.framework.TestCase;


import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class BuoyListingPresenterTest extends TestCase {

    private BuoyListingPresenter defaultPresenter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        defaultPresenter = new BuoyListingPresenter();
    }

    public void testSetView() {
        BuoyListingView view = mock(BuoyListingView.class);
        defaultPresenter.setView(view);
        verify(view).updateList(anyListOf(BuoyDescription.class));
    }

    public void testClearView() {
        BuoyListingView view = mock(BuoyListingView.class);
        defaultPresenter.setView(view);
        verify(view).updateList(anyListOf(BuoyDescription.class));
        defaultPresenter.clearView();
        defaultPresenter.selectRegion(Region.ATLANTIC);
        verifyNoMoreInteractions(view);
    }

    public void testSelectRegion_Atlantic() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.ATLANTIC);
        assertEquals(FakeBuoyListingGenerator.makeAtlanticBuoyListings(), view.descriptionList);
    }

    public void testSelectRegion_Pacific() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.PACIFIC);
        assertEquals(FakeBuoyListingGenerator.makePacificBuoyListings(), view.descriptionList);
    }

    public void testSelectRegion_Caribbean() {
        MockBuoyListingView view = new MockBuoyListingView();
        defaultPresenter.setView(view);
        defaultPresenter.selectRegion(Region.CARIBBEAN);
        assertEquals(FakeBuoyListingGenerator.makeCaribbeanBuoyListings(), view.descriptionList);
    }

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
