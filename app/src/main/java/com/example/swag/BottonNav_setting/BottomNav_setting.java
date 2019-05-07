package com.example.swag.BottonNav_setting;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.swag.Change_password.change_password;
import com.example.swag.OTP.OTP_verify;
import com.example.swag.Profile_edit.profile_edit;
import com.example.swag.R;
import com.example.swag.Services_products.Services;

public class BottomNav_setting extends AppCompatActivity
{
    ImageView gotochange,promo,sett_pass,sett_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_setting);

        gotochange = findViewById(R.id.gotochange);
        promo=findViewById(R.id.promo);
        sett_pass = findViewById(R.id.sett_pass);
        sett_home= findViewById(R.id.sett_home);

        sett_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sett_home = new Intent(BottomNav_setting.this, Services.class);
                startActivity(sett_home);
            }
        });

        sett_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sett_pro = new Intent(BottomNav_setting.this, profile_edit.class);
                startActivity(sett_pro);
            }
        });

        gotochange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(BottomNav_setting.this, change_password.class);
                startActivity(z);
            }
        });

        promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promo.setImageResource(R.drawable.percentage);
                Dialog dialog = new Dialog(BottomNav_setting.this);
                dialog.setContentView(R.layout.activity_popup_promo);
                dialog.show();
            }
        });


    }
}
