package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

import java.util.List;

public interface BuoyListingView {

    void updateList(List<BuoyDescription> descriptionList);

}
