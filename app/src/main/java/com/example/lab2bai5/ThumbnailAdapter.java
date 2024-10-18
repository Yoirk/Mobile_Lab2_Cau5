package com.example.lab2bai5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThumbnailAdapter extends BaseAdapter {
    private Context context;
    private Thumbnail[] thumbnails;

    public ThumbnailAdapter(Context context, Thumbnail[] thumbnails) {
        this.context = context;
        this.thumbnails = thumbnails;
    }

    @Override
    public int getCount() {
        return thumbnails.length;
    }

    @Override
    public Object getItem(int position) {
        return thumbnails[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail, parent, false);
        }

        TextView tvSelectedThumbnail = convertView.findViewById(R.id.tvSelectedThumbnail);
        tvSelectedThumbnail.setText(thumbnails[position].getName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        }

        ImageView imgThumbnail = convertView.findViewById(R.id.imgThumbnail);
        TextView tvThumbnailName = convertView.findViewById(R.id.tvThumbnailName);

        imgThumbnail.setImageResource(thumbnails[position].getImg());
        tvThumbnailName.setText(thumbnails[position].getName());

        return convertView;
    }
}

