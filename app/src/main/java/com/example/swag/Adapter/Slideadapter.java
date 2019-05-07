package com.example.swag.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.swag.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Slideadapter extends PagerAdapter {
    private Context mContext;
    private List<String> pageList;
    private ArrayList<Integer> images;

    public Slideadapter(Context mContext, List<String> pageList, ArrayList<Integer> images) {
        this.mContext = mContext;
        this.pageList = pageList;
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
//        final RelativeLayout llRow;
        final TextView tvPagetext;
        ImageView img_slider;


        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.custom_slide, collection, false);
//        llRow = layout.findViewById(R.id.llRow);

        img_slider = layout.findViewById(R.id.img_slider);
        tvPagetext = layout.findViewById(R.id.tvPagetext);

//        Random rnd = new Random();
//        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        llRow.setBackgroundColor(color);

        img_slider.setImageResource(images.get(position));
        tvPagetext.setText(pageList.get(position));



        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}