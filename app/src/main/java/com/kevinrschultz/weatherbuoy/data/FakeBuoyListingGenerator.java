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

    public static List<BuoyDescription> makePacificBuoyListings() {
        BuoyDescription one = new BuoyDescription(46089, "Tillamook");
        BuoyDescription two = new BuoyDescription(46012, "Half Moon Bay");
        BuoyDescription three = new BuoyDescription(46047, "Tanner Bank");
        return Lists.newArrayList(one, two, three);
    }

    public static List<BuoyDescription> makeCaribbeanBuoyListings() {
        BuoyDescription one = new BuoyDescription(41047, "North East Bahamas");
        BuoyDescription two = new BuoyDescription(41046, "East Bahamas");
        BuoyDescription three = new BuoyDescription(41040, "North Equatorial One");
        return Lists.newArrayList(one, two, three);
    }
}
