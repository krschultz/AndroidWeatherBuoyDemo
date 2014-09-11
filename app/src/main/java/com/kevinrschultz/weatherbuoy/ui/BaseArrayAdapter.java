package com.kevinrschultz.weatherbuoy.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Add newView/bindView methods to ArrayAdapter
 */
public abstract class BaseArrayAdapter<T, VH> extends ArrayAdapter<T> {

    private LayoutInflater mInflater;

    private int mLayout;

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource) {
        super(context, resource);
        init(resource);
    }

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        init(resource);
    }

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
        init(resource);
    }

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
        init(resource);
    }

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        init(resource);
    }

    /** {@inheritDoc} */
    public BaseArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
        init(resource);
    }

    private void init(int resource) {
        mLayout = resource;
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newView(getContext(), position, parent);
            v.setTag(getViewHolder(v, position, getContext()));
        } else {
            v = convertView;
        }
        bindView(v, position, getContext());
        return v;
    }

    protected View newView(Context context, int position, ViewGroup parent) {
        return mInflater.inflate(mLayout, parent, false);
    }

    protected abstract VH getViewHolder(View v, int position, Context c);

    protected abstract void bindView(View v, int position, Context context);

}
