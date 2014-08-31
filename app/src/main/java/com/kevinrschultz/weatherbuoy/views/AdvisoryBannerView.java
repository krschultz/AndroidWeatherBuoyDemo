package com.kevinrschultz.weatherbuoy.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.common.base.Optional;
import com.kevinrschultz.weatherbuoy.R;

/**
 * @author Kevin Schultz
 */
public class AdvisoryBannerView extends FrameLayout implements OptionalTextView {

    private static final String TAG = AdvisoryBannerView.class.getSimpleName();

    private TextView label;

    public AdvisoryBannerView(Context context) {
        super(context);
        init();
    }

    public AdvisoryBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AdvisoryBannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        View v = inflate(getContext(), R.layout.view_advisory_banner, this);
        label = TextView.class.cast(v.findViewById(R.id.view_advisory_banner_label));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptionalText(Optional<String> optionalText) {
        if(optionalText.isPresent() && !TextUtils.isEmpty(optionalText.get())) {
            label.setText(optionalText.get());
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
    }
}
