package com.example.swag.Profile_save;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.swag.Profile_edit.profile_edit;
import com.example.swag.R;

public class profile_save extends AppCompatActivity
{

    ImageView prev_pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_save);

        prev_pro = findViewById(R.id.prev_pro);

        prev_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prev_pro = new Intent(profile_save.this, profile_edit.class);
                startActivity(prev_pro);
            }
        });
    }
}
