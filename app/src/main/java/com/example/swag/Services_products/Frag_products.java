package com.example.swag.Services_products;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.swag.Interface.Api;
import com.example.swag.Model.GetHomeDataModel;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag_products extends Fragment
{
    RecyclerView recycler_products;
    public List<GetHomeDataModel.Detail> productitem;
    View v;
    public Frag_products() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_frag_products, container, false);
        recycler_products = v.findViewById(R.id.recycler_products);


        Api apii = ApiClient.getApiClient().create(Api.class);
        Call<GetHomeDataModel> call = apii.getProduct();
        call.enqueue(new Callback<GetHomeDataModel>()
        {
            @Override
            public void onResponse(Call<GetHomeDataModel> call, Response<GetHomeDataModel> response)
            {
                if (response.isSuccessful()) {
                    productitem = response.body().getDetails();
                    Adapter_products adapter1 = new Adapter_products(getActivity(), productitem);
                    recycler_products.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recycler_products.setAdapter(adapter1);
                }

                }

            @Override
            public void onFailure(Call<GetHomeDataModel> call, Throwable t)
            {

            }
        });



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
