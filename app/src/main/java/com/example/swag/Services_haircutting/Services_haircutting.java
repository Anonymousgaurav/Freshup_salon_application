package com.example.swag.Services_haircutting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.swag.R;

public class Services_haircutting extends AppCompatActivity
{
    RecyclerView services_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_haircutting);

        services_type= findViewById(R.id.services_type);

    }
}
