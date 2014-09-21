package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.data.FakeBuoyListingGenerator;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;
import com.kevinrschultz.weatherbuoy.model.Region;

import java.util.List;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class BuoyListingPresenter {

    private BuoyListingView view;

    public BuoyListingPresenter() {
        this.view = new NoOpBuoyListingView();
    }

    // Lifecycle methods

    public void setView(BuoyListingView view) {
        this.view = view;
        selectRegion(Region.ATLANTIC);
    }

    public void clearView() {
        setView(new NoOpBuoyListingView());
    }

    // Business logic

    public void selectRegion(Region region) {
        if (region == null) {
            region = Region.ATLANTIC;
        }
        List<BuoyDescription> descriptions;
        switch(region) {
            case ATLANTIC:
                descriptions = FakeBuoyListingGenerator.makeAtlanticBuoyListings();
                break;
            case CARIBBEAN:
                descriptions = FakeBuoyListingGenerator.makeCaribbeanBuoyListings();
                break;
            case PACIFIC:
                descriptions = FakeBuoyListingGenerator.makePacificBuoyListings();
                break;
            default:
                descriptions = FakeBuoyListingGenerator.makeAtlanticBuoyListings();
        }
        view.updateList(descriptions);
    }

    private static class NoOpBuoyListingView implements BuoyListingView {
        @Override
        public void updateList(List<BuoyDescription> descriptionList) {
        }
    }
}
