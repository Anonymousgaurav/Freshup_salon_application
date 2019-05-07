package com.example.swag.Services_haircut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.swag.R;

public class services_haircut extends AppCompatActivity
{

    ImageView select_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_haircut);

        select_img = findViewById(R.id.select_img);
        select_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_img.setImageResource(R.drawable.select_round);
            }
        });
    }
}
