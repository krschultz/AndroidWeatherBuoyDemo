package com.kevinrschultz.weatherbuoy.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kevinrschultz.weatherbuoy.R;
import com.kevinrschultz.weatherbuoy.model.BuoyDescription;

/**
 * @author Kevin Schultz (kschultz@gilt.com)
 */
public class BuoyDescriptionAdapter extends BaseArrayAdapter<BuoyDescription, BuoyDescriptionAdapter.ViewHolder> {

    public BuoyDescriptionAdapter(Context context) {
        super(context, R.layout.row_buoy_description);
    }

    @Override
    public void bindView(View v, int position, Context context) {
        ViewHolder holder = (ViewHolder) v.getTag();
        BuoyDescription description = getItem(position);
        holder.id.setText(Integer.toString(description.getId()));
        holder.name.setText(description.getName());
    }

    @Override
    protected ViewHolder getViewHolder(View v, int position, Context c) {
        ViewHolder holder;
        if (v.getTag() instanceof ViewHolder) {
            holder = ViewHolder.class.cast(v.getTag());
        } else {
            holder = new ViewHolder();
            holder.id = (TextView) v.findViewById(R.id.row_buoy_description_id);
            holder.name = (TextView) v.findViewById(R.id.row_buoy_description_name);
        }
        return holder;
    }

    static class ViewHolder {
        TextView id;
        TextView name;
    }

}
