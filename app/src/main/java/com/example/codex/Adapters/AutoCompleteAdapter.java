package com.example.codex.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.codex.R;

import java.util.List;

public class AutoCompleteAdapter extends ArrayAdapter {

    private final Activity activity;
    private Context mContext;
    private int layoutResourceId;
    private List<String> data;

    public AutoCompleteAdapter(@NonNull Context context, int resource, Activity activity, List<String> data) {
        super(context, resource);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.activity = activity;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        try {

            /*
             * The convertView argument is essentially a "ScrapView" as described is Lucas post
             * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
             * It will have a non-null value when ListView is asking you recycle the row layout.
             * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
             */
            if (convertView == null) {
                // inflate the layout
                LayoutInflater inflater = activity.getLayoutInflater();
                convertView = inflater.inflate(layoutResourceId, parent, false);
            }

            // object item based on the position
            String objectItem = data.get(position);

            // get the TextView and then set the text (item name) and tag (item ID) values
            TextView textViewItem = (TextView) convertView.findViewById(R.id.tvAutocompleteListItem);
            textViewItem.setText(objectItem);

            // in case you want to add some style, you can do something like:
            //textViewItem.setBackgroundColor(Color.CYAN);

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;

    }
}
