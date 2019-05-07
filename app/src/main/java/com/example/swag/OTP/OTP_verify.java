package com.example.swag.OTP;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swag.Interface.Api;
import com.example.swag.Model.RegisterModel;
import com.example.swag.Model.SimplePojo;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import com.example.swag.Services_products.Frag_services;
import com.example.swag.Services_products.Services;
import com.example.swag.Services_products.Services_items;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTP_verify extends AppCompatActivity {

    Button ShowPopup;
    RelativeLayout linearlayout1;
    String a;
    int c;
    EditText otp1,otp2,otp3,otp4;
    TextView resend_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);

        ShowPopup = findViewById(R.id.ShowPopup);
        linearlayout1 = (RelativeLayout)findViewById(R.id.linearlayout1);
        otp1 = findViewById(R.id.otp1);
        otp2= findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);


        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)

            {

                if(s.length()==1)
                {
                    otp2.requestFocus();
                }
                else if(s.length()==0)
                {

                }


            }
        });

        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                if(s.length()==1)
                {
                    otp2.requestFocus();
                }
                else if(s.length()==0)
                {

                }

            }
        });


        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                if(s.length()==1)
                {
                    otp2.requestFocus();
                }
                else if(s.length()==0)
                {

                }
            }
        });



        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                if(s.length()==1)
                {
                    otp2.requestFocus();
                }
                else if(s.length()==0)
                {

                }
            }
        });


        Intent abc = getIntent();
        Bundle b = abc.getExtras();
        c = b.getInt("id");
        a = b.getString("token");


        ShowPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Api apii = ApiClient.getApiClient().create(Api.class);
                Call<SimplePojo>call = apii.matchToken(c,a);

                 call.enqueue(new Callback<SimplePojo>() {
                    @Override
                    public void onResponse(Call<SimplePojo> call, Response<SimplePojo> response)
                    {
//                        SimplePojo loginResponse = response.body();

                        if (response.body().getSuccess().equalsIgnoreCase("1"))
                        {
                            Toast.makeText(OTP_verify.this, response.message(), Toast.LENGTH_SHORT).show();
                            Dialog dialog = new Dialog(OTP_verify.this);
                            dialog.setContentView(R.layout.activity_popup_otp_verified);
                            Button successverified1 = dialog.findViewById(R.id.successverified1);

                            successverified1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                    Intent xy = new Intent(OTP_verify.this, Services.class);
                                    startActivity(xy);
                                }
                            });
                            dialog.show();

                        }

                        else
                        {
                            Toast.makeText(OTP_verify.this, "error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<SimplePojo> call, Throwable t) {

                    }
                });

            }


        });

        resend_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


            }
        });
    }


}