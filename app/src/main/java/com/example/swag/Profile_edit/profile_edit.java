package com.example.swag.Profile_edit;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.swag.BottonNav_setting.BottomNav_setting;
import com.example.swag.Interface.Api;
import com.example.swag.Model.GetProfilePojo;
import com.example.swag.POP_UP.promo;
import com.example.swag.Profile_save.profile_save;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import com.example.swag.Services_products.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile_edit extends AppCompatActivity
{
    ImageView pro_home,promo,pro_setting,add_image,edit_profile,img_profile;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        pro_home= findViewById(R.id.pro_home);
        promo = findViewById(R.id.promo);
        pro_setting = findViewById(R.id.pro_setting);
        add_image = findViewById(R.id.add_image);
        edit_profile = findViewById(R.id.edit_profile);
        img_profile = findViewById(R.id.img_profile);

        img_profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profilesave =  new Intent(profile_edit.this, profile_save.class);
                startActivity(profilesave);
            }
        });

        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                image =
//
//
//                Api apiii = ApiClient.getApiClient().create(Api.class);
//                apiii.getProfile().enqueue(new Callback<GetProfilePojo>() {
//                    @Override
//                    public void onResponse(Call<GetProfilePojo> call, Response<GetProfilePojo> response)
//                    {
//                        GetProfilePojo loginResponse = response.body();
//
//                        if (response.isSuccessful())
//                        {
//
//                        }
//
//                        else
//                        {
//
//                        }


            }
        });

        promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                promo.setImageResource(R.drawable.percentage);
                Dialog dialog = new Dialog(profile_edit.this);
                dialog.setContentView(R.layout.activity_popup_promo);
                dialog.show();
            }
        });

        pro_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bk = new Intent(profile_edit.this, Services.class);
                startActivity(bk);
            }
        });

        pro_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sett = new Intent(profile_edit.this, BottomNav_setting.class);
                startActivity(sett);
            }
        });
    }
}
