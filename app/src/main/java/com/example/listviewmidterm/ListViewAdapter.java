package com.example.listviewmidterm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

class ListViewAdapter extends ArrayAdapter<String> {
    private final Activity activity;
    private final ArrayList<String> repositoryName;
    private final ArrayList<String> ownerName;

    public ListViewAdapter(Activity activity, ArrayList<String> repositoryName, ArrayList<String> ownerName) {
        super(activity, 0);
        this.activity=activity;
        this.repositoryName =repositoryName;
        this.ownerName = ownerName;
    }

    @Override
    public int getCount() {
        return repositoryName.size();
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

        titleText.setText(repositoryName.get(position));
        subtitleText.setText(ownerName.get(position));

        return convertView;
    };
}

