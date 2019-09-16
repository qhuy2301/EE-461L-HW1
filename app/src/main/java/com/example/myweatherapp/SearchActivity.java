package com.example.myweatherapp;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

public class SearchActivity extends Activity {
    EditText text1;
    Button b1;
    String location;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        text1 = findViewById(R.id.location);
        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, MainActivity.class);
                location = text1.getText().toString();
                in.putExtra("location", location);
                startActivity(in);
            }
        });

    }
}
