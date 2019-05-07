package com.example.swag.Services_products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.swag.Interface.Api;
import com.example.swag.Model.GetServicesDataModel;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;

import java.util.List;


public class Services_items extends AppCompatActivity
{
     RecyclerView rview_item_services;
     List<Model_services> servicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_items);

        rview_item_services = findViewById(R.id.rview_item_services);
        LinearLayoutManager linearLayoutManager_service = new LinearLayoutManager(this);
        linearLayoutManager_service.setOrientation(LinearLayoutManager.VERTICAL);
        rview_item_services.setLayoutManager(linearLayoutManager_service);
        Adapter_service_items adapter_service_itemss = new Adapter_service_items(this,servicesList);
        rview_item_services.setAdapter(adapter_service_itemss);


    }
}
