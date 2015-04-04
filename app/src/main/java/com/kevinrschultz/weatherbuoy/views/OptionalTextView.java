package com.kevinrschultz.weatherbuoy.views;

import com.google.common.base.Optional;

public interface OptionalTextView {

    /**
     * Set text if present, otherwise hide the view
     *
     * @param optionalText
     */
    void setOptionalText(Optional<String> optionalText);

}
