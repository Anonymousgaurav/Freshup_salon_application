package com.example.swag.Sign_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swag.Interface.Api;
import com.example.swag.Model.RegisterModel;
import com.example.swag.OTP.OTP_verify;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import com.example.swag.Sign_in.Sign_in;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_up extends AppCompatActivity {

    TextView tvusersignin;
    Button btnsignup;
    EditText etusername, etemail, etpwd, etcnfrmpwd, etphone;
    String username, email, password, confirmpassword, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tvusersignin = findViewById(R.id.tvusersignin);
        btnsignup = findViewById(R.id.btnsignup);
        etusername = findViewById(R.id.etusername);
        etemail = findViewById(R.id.etemail);
        etpwd = findViewById(R.id.etpwd);
        etcnfrmpwd = findViewById(R.id.etcnfrmpwd);
        etphone = findViewById(R.id.etphone);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etusername.getText().toString();
                email = etemail.getText().toString();
                phone = etphone.getText().toString();
                password = etpwd.getText().toString();
                confirmpassword = etcnfrmpwd.getText().toString();


                Api apii = ApiClient.getApiClient().create(Api.class);
                apii.UserRegister(username, email, phone, password, "Android", "0").enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        if (response.body().getSuccess().equalsIgnoreCase("1")) {
                            int token = response.body().getDetails().getOtp();
                            Toast.makeText(Sign_up.this, response.body().getDetails().getOtp().toString(), Toast.LENGTH_SHORT).show();
                            Intent otpverify = new Intent(Sign_up.this, OTP_verify.class);
                            otpverify.putExtra("id", response.body().getDetails().getId());
                            otpverify.putExtra("token", token);
                            startActivity(otpverify);

                        } else {

                            Toast.makeText(Sign_up.this, "These Credentials already exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                    }
                });

            }
        });

        tvusersignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(Sign_up.this, Sign_in.class);
                startActivity(b);
            }
        });
    }
}
