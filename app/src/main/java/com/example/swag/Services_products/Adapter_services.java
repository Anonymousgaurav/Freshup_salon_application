package com.example.swag.Services_products;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.swag.Interface.Api;
import com.example.swag.Model.GetHomeDataModel;
import com.example.swag.R;
import com.example.swag.Retrofit.ApiClient;
import com.example.swag.Services_haircut.services_haircut;
import com.example.swag.Services_haircutting.Services_haircutting;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;

public class Adapter_services extends RecyclerView.Adapter<Adapter_services.ViewHolder> {

     Context mcontext;
    List<GetHomeDataModel.Detail> list = Collections.emptyList();

    public Adapter_services(Context mcontext, List<GetHomeDataModel.Detail> list)
    {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.custom_services, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {

        Picasso.get().load(list.get(i).getImage1()).into(viewHolder.custom_img_services);
        Picasso.get().load(list.get(i).getImage2()).into(viewHolder.custom_img_services2);

        viewHolder.service_rl.setOnClickListener(new View.OnClickListener()
        {
                @Override
                public void onClick(View v)
                {
                    Intent opp = new Intent(mcontext, Services_haircutting.class);
                    mcontext.startActivity(opp);

                }
            });

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout service_rl;
        ImageView custom_img_services,custom_img_services2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            service_rl = itemView.findViewById(R.id.service_rl);
//            service_rl2 = itemView.findViewById(R.id.service_rl2);
//            service_rl3 = itemView.findViewById(R.id.service_rl3);
            custom_img_services = itemView.findViewById(R.id.custom_img_services);
            custom_img_services2 = itemView.findViewById(R.id.custom_img_services2);
        }

    }

}
