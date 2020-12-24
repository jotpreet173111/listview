package com.example.listviewmidterm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

class ListViewAdapter extends BaseAdapter {
    private final Activity activity;
    ArrayList<Read> readArrayList;

    public ListViewAdapter(Activity activity,  ArrayList<Read> readArrayList) {

        this.activity=activity;
        this.readArrayList =readArrayList;

    }

    @Override
    public int getCount() {
        return readArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return readArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cutomlayout, parent, false);
        }

        TextView titleText = convertView.findViewById(R.id.repo);
        TextView subtitleText = convertView.findViewById(R.id.owner);

        titleText.setText(readArrayList.get(position).getName());
        subtitleText.setText(readArrayList.get(position).getName());

        return convertView;
    };
}

