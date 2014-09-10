package com.kevinrschultz.weatherbuoy.ui;

import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

import java.util.List;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public interface BuoyListingView {

    public void updateList(List<BuoyDescription> descriptionList);

}
