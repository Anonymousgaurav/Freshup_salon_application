package com.example.swag.Services_products;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.swag.R;

import java.util.List;

public class Adapter_product_items extends RecyclerView.Adapter<Adapter_product_items.itemholder>
{

    private Context context;
    private List<Model_products> product_items;

    public Adapter_product_items(Context context, List<Model_products> product_items) {
        this.context = context;
        this.product_items = product_items;
    }

    @NonNull
    @Override
    public itemholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_products_items,viewGroup,false);
        itemholder th = new itemholder(v);
        return th;
    }

    @Override
    public void onBindViewHolder(@NonNull itemholder itemholder, int i)
    {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class itemholder extends RecyclerView.ViewHolder
    {
        public itemholder(@NonNull View itemView)
        {
            super(itemView);

        }


    }
}
