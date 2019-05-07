package com.example.swag.Services_products;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.swag.Interface.Api;
import com.example.swag.Model.GetHomeDataModel;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag_services extends Fragment
{
    RecyclerView recycler_services;
    public List<GetHomeDataModel.Detail> serviceitem;
    public Frag_services()
    {
    }
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_frag_services, container, false);
        recycler_services = v.findViewById(R.id.recycler_services);

        Api apii = ApiClient.getApiClient().create(Api.class);
        Call<GetHomeDataModel> call = apii.getServices();
        call.enqueue(new Callback<GetHomeDataModel>() {
            @Override
            public void onResponse(Call<GetHomeDataModel> call, Response<GetHomeDataModel> response)
            {
                if (response.isSuccessful())
                {
                    serviceitem = response.body().getDetails();
                    Adapter_services adapter = new Adapter_services(getActivity(),serviceitem);
                    recycler_services.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recycler_services.setAdapter(adapter);
                }

            }


            @Override
            public void onFailure(Call<GetHomeDataModel> call, Throwable t) {

            }
        });




        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
