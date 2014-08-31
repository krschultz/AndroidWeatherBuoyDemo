package com.kevinrschultz.weatherbuoy.views;

import com.google.common.base.Optional;

/**
 * @author Kevin Schultz
 */
public interface OptionalTextView {

    /**
     * Set text if present, otherwise hide the view
     *
     * @param optionalText
     */
    public void setOptionalText(Optional<String> optionalText);

}
