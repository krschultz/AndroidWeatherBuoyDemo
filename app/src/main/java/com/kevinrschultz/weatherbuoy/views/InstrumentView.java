package com.kevinrschultz.weatherbuoy.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kevinrschultz.weatherbuoy.R;


/**
 * @author Kevin Schultz
 */
public class InstrumentView extends RelativeLayout implements Instrument {

    private TextView labelView;
    private TextView measurementView;
    private TextView unitsView;

    private String labelText;

    public InstrumentView(Context context) {
        super(context);
        init();
    }

    public InstrumentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InstrumentView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.InstrumentView, 0, 0);
        try {
            labelText = ta.getString(R.styleable.InstrumentView_labelText);
            init();
        } finally {
           // why does un commenting this crash? Should not be the case?
           // ta.recycle();
        }
    }

    private void init() {
        View v = inflate(getContext(), R.layout.view_instrument, this);
        labelView = TextView.class.cast(v.findViewById(R.id.view_instrument_label));
        measurementView = TextView.class.cast(v.findViewById(R.id.view_instrument_measurement));
        unitsView = TextView.class.cast(v.findViewById(R.id.view_instrument_units));
        if(!TextUtils.isEmpty(labelText)) {
            setLabel(labelText);
        }
    }

    @Override
    public void setLabel(String label) {
        labelView.setText(label);
    }

    @Override
    public void updateReading(String value, String units) {
        measurementView.setText(value);
        unitsView.setText(units);
    }

}
