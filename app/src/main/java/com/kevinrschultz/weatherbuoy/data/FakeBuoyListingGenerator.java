package com.kevinrschultz.weatherbuoy.data;

import com.google.common.collect.Lists;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

import java.util.List;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class FakeBuoyListingGenerator {

    public static List<BuoyDescription> makeAtlanticBuoyListings() {
        return Lists.newArrayList(new BuoyDescription(1, "test"));
    }
}
