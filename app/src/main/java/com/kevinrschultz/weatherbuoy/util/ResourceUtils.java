package com.kevinrschultz.weatherbuoy.util;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

/**
 * A few test helpers
 */
public class ResourceUtils {

    /**
     * Reads the entire contents of a resource file into a single string.
     * @param resourceFileName - appended to src/androidTest/resources/
     */
    public static String getStringFromResourceFile(String resourceFileName) throws IOException {
        URL url = Resources.getResource(resourceFileName);
        return Resources.toString(url, Charsets.UTF_8);
    }
}
