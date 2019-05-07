package com.example.swag.Services_products;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.swag.Model.GetHomeDataModel;
import com.example.swag.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adapter_products extends RecyclerView.Adapter<Adapter_products.holder>
{

    private Context mcontext;
    List<GetHomeDataModel.Detail> listt = Collections.emptyList();


    public Adapter_products(Context mcontext, List<GetHomeDataModel.Detail> listt)
    {
        this.mcontext = mcontext;
        this.listt = listt;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.custom_products,viewGroup,false);
        holder hld = new holder(v);
        return  hld;
    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, int i)
    {


        Picasso.get().load(listt.get(i).getImage1()).into(holder.custom_img_products);
        Picasso.get().load(listt.get(i).getImage2()).into(holder.custom_img_products2);
        holder.product_item_list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mnc = new Intent(mcontext,Products.class);
                mcontext.startActivity(mnc);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listt.size();

    }

    public class holder extends RecyclerView.ViewHolder
    {

        RelativeLayout product_item_list1;
        ImageView custom_img_products,custom_img_products2;

        public holder(@NonNull View itemView) {
            super(itemView);
            product_item_list1 = itemView.findViewById(R.id.product_item_list1);
            custom_img_products = itemView.findViewById(R.id.custom_img_products);
            custom_img_products2 = itemView.findViewById(R.id.custom_img_products2);

        }
    }
}
