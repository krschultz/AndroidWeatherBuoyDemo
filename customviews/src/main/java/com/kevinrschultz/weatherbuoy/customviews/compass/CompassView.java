package com.kevinrschultz.weatherbuoy.customviews.compass;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.kevinrschultz.weatherbuoy.customviews.R;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class CompassView extends View implements Compass {

    private double waveDirection = 0;

    private double windDirection = 0;

    private Paint waveArrowPaint, windArrowPaint, compassFacePaint;

    private float xPadding, yPadding;
    private float widthNoPadding, heightNoPadding;

    private RectF outterBounds;

    public CompassView(Context context) {
        super(context);
        init();
    }

    public CompassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CompassView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Resources res = getResources();
        waveArrowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        waveArrowPaint.setColor(res.getColor(R.color.wave_arrow));
        windArrowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        windArrowPaint.setColor(res.getColor(R.color.wind_arrow));
        compassFacePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        compassFacePaint.setColor(res.getColor(R.color.compass_face));
        outterBounds = new RectF();
    }

    @Override
    public void setWaveDirection(double waveDirection) {
        this.waveDirection = waveDirection;
        this.invalidate();
    }

    @Override
    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
        this.invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Account for padding
        xPadding = (float)(getPaddingLeft() + getPaddingRight());
        yPadding = (float)(getPaddingTop() + getPaddingBottom());

        widthNoPadding = (float) w - xPadding;
        heightNoPadding = (float) h - yPadding;

        outterBounds.set(0, 0, widthNoPadding, heightNoPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(outterBounds, compassFacePaint);

        final float arrowLength = getArrowLength();
        final PointF center = getCenter();
        final PointF endWave = getEndPoint(center, waveDirection, arrowLength);
        final PointF endWind = getEndPoint(center, windDirection, arrowLength);
        canvas.drawLine(center.x, center.y, endWave.x, endWave.y, waveArrowPaint);
        canvas.drawLine(center.x, center.y, endWind.x, endWind.y, windArrowPaint);
    }

    private PointF getCenter() {
        return new PointF(widthNoPadding / 2f, heightNoPadding / 2f);
    }

    private PointF getEndPoint(PointF origin, double direction, float length) {
        double x = origin.x + length * Math.sin(Math.toRadians(direction));
        double y = origin.y - length * Math.cos(Math.toRadians(direction));
        return new PointF((float) x, (float) y);
    }

    private float getArrowLength() {
        return widthNoPadding / 2f;
    }

}


