package com.example.swag.Services_products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.swag.R;
import java.util.List;

public class Products extends AppCompatActivity
{

    RecyclerView rview_item_products;
     List<Model_products> product_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        rview_item_products = findViewById(R.id.rview_item_products);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rview_item_products.setLayoutManager(linearLayoutManager);
        Adapter_product_items adapter_product_items = new Adapter_product_items(this,product_items);
        rview_item_products.setAdapter(adapter_product_items);
    }
}
