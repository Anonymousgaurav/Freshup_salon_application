package com.example.swag.Sign_in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swag.Calender_Time.Time_slot;
import com.example.swag.Interface.Api;
import com.example.swag.Model.GetProfilePojo;
import com.example.swag.Model.OtpPojo;
import com.example.swag.OTP.OTP_verify;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import com.example.swag.Services_products.Services;
import com.example.swag.Sign_up.Sign_up;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_in extends AppCompatActivity
{
    TextView signintv;
    Button btnsignin,fb_signin;
    EditText etemail,etpassword;
    String Email,Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signintv= findViewById(R.id.signintv);
        btnsignin=findViewById(R.id.btnsignin);
        fb_signin = findViewById(R.id.fb_signin);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);


        fb_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zz = new Intent(Sign_in.this, Time_slot.class);
                startActivity(zz);
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Email = etemail.getText().toString();
                Password = etpassword.getText().toString();

                Api apiii = ApiClient.getApiClient().create(Api.class);
                apiii.UserLogin(Email,Password).enqueue(new Callback<GetProfilePojo>() {
                    @Override
                    public void onResponse(Call<GetProfilePojo> call, Response<GetProfilePojo> response)
                    {
                        GetProfilePojo loginResponse = response.body();

                        if (response.body().getSuccess().equalsIgnoreCase("2")) {
                            Toast.makeText(Sign_in.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                            Intent defgh = new Intent(Sign_in.this, Services.class);
                            startActivity(defgh);
                        }

                        else
                        {
                            Toast.makeText(Sign_in.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetProfilePojo> call, Throwable t)
                    {
                        Toast.makeText(Sign_in.this, "Failed To Login", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signintv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Sign_in.this,Sign_up.class);
                startActivity(a);
            }
        });
   }
}
