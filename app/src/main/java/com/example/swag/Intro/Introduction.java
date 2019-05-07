package com.example.swag.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.example.swag.Adapter.Slideadapter;
import com.example.swag.MainActivity;
import com.example.swag.R;
import com.example.swag.Sign_in.Sign_in;

import java.util.ArrayList;
import java.util.List;

public class Introduction extends AppCompatActivity {

    List<String> pageList;
    ArrayList<Integer> images;
    ViewPager slideviewpager;
    Slideadapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        pageList = new ArrayList<>();
        slideviewpager = findViewById(R.id.slideviewpager);

        images = new ArrayList<Integer>() {{
            add(R.drawable.layy1);
            add(R.drawable.slide_22);
            add(R.drawable.lay_3);
        }};

        for (int i = 0; i < 3; i++) {
            pageList.add("Page : " + (i + 1));

            slideviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    if (i == 2) {

                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    this.sleep(3000);
                                    startActivity(new Intent(Introduction.this, Sign_in.class));
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        thread.start();

                    }

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

        }



        pagerAdapter = new Slideadapter(this, pageList, images);
        slideviewpager.setAdapter(pagerAdapter);


        //this is default viewpager now add some animation to our viewpager by adding toxic Bakery Library

        //now add some constructor for animation like this
        slideviewpager.setPageTransformer(true, new RotateDownTransformer());
        //you can apply anyone you want lets Run

        //there are Some other animation if you want to apply

        /*   like StackTransformer()
                  RotateDownTransformer()
                  CubeOutTransformer()
                  CubeInTransformer()
                  ZoomInTransformer()
                  ZoomOutTransformer()
                   ZoomOutSlideTransformer()
                   ScaleInOutTransformer()
                   ScaleInOutTransformer()
                   DrawerTransformer()
                   AccordionTransformer()
                   ForegroundToBackgroundTransformer()
                   FlipVerticalTransformer()
                   ABaseTransformer()
                   DepthPageTransformer()
                   RotateUpTransformer()
                   BackgroundToForegroundTransformer()          */


    }
}
