package com.example.listviewmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDetail extends AppCompatActivity {

    TextView name;
    TextView login;
    TextView branch;
    TextView tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_detail);
        name=findViewById(R.id.name);
        login=findViewById(R.id.login);
        branch=findViewById(R.id.branch);
        tree=findViewById(R.id.tree);

        Intent intent=getIntent();
        Read read=intent.getParcelableExtra("readDetails");
        name.setText(read.getName());
        login.setText(read.getLogin());
        branch.setText(read.getBranchUrl());
        tree.setText(read.getTreeUrl());


    }
}