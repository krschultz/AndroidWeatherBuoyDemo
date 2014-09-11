package com.kevinrschultz.weatherbuoy.data;

import com.google.common.collect.Lists;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

import java.util.List;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class FakeBuoyListingGenerator {

    public static List<BuoyDescription> makeAtlanticBuoyListings() {
        BuoyDescription one = new BuoyDescription(41002, "South Hatteras");
        BuoyDescription two = new BuoyDescription(41025, "Diamond Shoals");
        BuoyDescription three = new BuoyDescription(44009, "Delaware Bay");
        return Lists.newArrayList(one, two, three);
    }

}
