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

    public InstrumentView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public InstrumentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public InstrumentView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.InstrumentView, defStyle, 0);
        String labelText = ta.getString(R.styleable.InstrumentView_labelText);
        ta.recycle();

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
