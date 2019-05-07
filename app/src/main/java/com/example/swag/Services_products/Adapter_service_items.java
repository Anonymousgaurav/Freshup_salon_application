package com.example.swag.Services_products;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.swag.R;
import java.util.List;

public class Adapter_service_items extends RecyclerView.Adapter<Adapter_service_items.serviceholder>
{
    private Context context;
    private List<Model_services> service_items;

    public Adapter_service_items(Context context, List<Model_services> service_items)
    {
        this.context = context;
        this.service_items = service_items;
    }

    @NonNull
    @Override
    public serviceholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_services,viewGroup,false);
        serviceholder sh = new serviceholder(v);
        return sh;
    }

    @Override
    public void onBindViewHolder(@NonNull serviceholder serviceholder, int i)
    {

    }

    @Override
    public int getItemCount()
    {
        return 10;
    }

    public class serviceholder extends RecyclerView.ViewHolder{

        public serviceholder(@NonNull View itemView)
        {
            super(itemView);
        }
    }
}
