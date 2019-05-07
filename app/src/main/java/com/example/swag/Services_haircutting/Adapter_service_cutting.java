package com.example.swag.Services_haircutting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swag.Model.GetServicesDataModel;
import com.example.swag.R;
import com.example.swag.Services_products.Adapter_services;

import java.util.List;

public class Adapter_service_cutting extends RecyclerView.Adapter<Adapter_service_cutting.cutttingholder>
{

    private Context mcontext;
    List<GetServicesDataModel> list;

    public Adapter_service_cutting(Context mcontext, List<GetServicesDataModel> list)
    {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public cutttingholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.sub_services_recycler_items, viewGroup, false);
        cutttingholder ch = new cutttingholder(v);
        return ch;
    }

    @Override
    public void onBindViewHolder(@NonNull cutttingholder cutttingholder, int i)
    {
        GetServicesDataModel model=list.get(i);
        cutttingholder.services_type.setText("Gaurav");
        cutttingholder.services_expanded_recycler_view.setLayoutManager(new LinearLayoutManager(mcontext));
        cutttingholder.expand_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class cutttingholder extends RecyclerView.ViewHolder
    {
        TextView services_type;
        ImageView btn_expand;
        RecyclerView services_expanded_recycler_view;
        LinearLayout expand_card;

        public cutttingholder(@NonNull View itemView) {
            super(itemView);

            services_type = itemView.findViewById(R.id.services_type_text_view);
            btn_expand = itemView.findViewById(R.id.btn_expand);
            services_expanded_recycler_view = itemView.findViewById(R.id.services_expanded_recycler_view);
            expand_card = itemView.findViewById(R.id.expand_card);


        }
    }
}
