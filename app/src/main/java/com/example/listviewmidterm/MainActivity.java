package com.example.listviewmidterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReadInfo data= new ReadInfo(MainActivity.this);
        data.execute("https://api.github.com/repositories");
    }
}