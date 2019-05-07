package com.example.swag.Services_products;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.swag.BottonNav_setting.BottomNav_setting;
import com.example.swag.Profile_edit.profile_edit;
import com.example.swag.R;
import java.util.ArrayList;
import java.util.List;

public class Services extends AppCompatActivity {

    Button btnservices,btnproducts;
    ImageView settingg,percentage;
    ImageView  promo_serv,user_profile;
    List<String> servicess = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        btnservices = findViewById(R.id.btnservices);
        btnproducts= findViewById(R.id.btnproducts);
        settingg = findViewById(R.id.settingg);
        promo_serv = findViewById(R.id.promo_serv);
        user_profile=findViewById(R.id.user_profile);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framecontainer,new Frag_services());
        ft.commit();


        user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user_profile.setImageResource(R.drawable.profile_iocn);
                Intent abc = new Intent(Services.this, profile_edit.class);
                startActivity(abc);
            }
        });


        settingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent s = new Intent(Services.this, BottomNav_setting.class);
                startActivity(s);
            }
        });

        btnservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framecontainer,new Frag_services());
                ft.commit();

            }
        });

        btnproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framecontainer,new Frag_products());
                ft.commit();

            }
        });


        promo_serv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                promo_serv.setImageResource(R.drawable.percentage);
                Dialog dialog = new Dialog(Services.this);
                dialog.setContentView(R.layout.activity_popup_promo);
                dialog.show();
            }
        });

    }
}
