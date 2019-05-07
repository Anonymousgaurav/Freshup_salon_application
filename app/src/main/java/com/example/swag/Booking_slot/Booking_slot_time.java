package com.example.swag.Booking_slot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.swag.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import noman.weekcalendar.WeekCalendar;

public class Booking_slot_time extends AppCompatActivity
{
    WeekCalendar weekCalendar;
    Calendar cal;
    SimpleDateFormat sdf, sdf1;
    String datedata = "";
    String currentDate,day;
    TextView getDate;
    String[] weekday;
    RecyclerView barber_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_slot_time);

        weekCalendar =findViewById(R.id.weekCalendar);
        getDate = findViewById(R.id.getDate);
        barber_recycler = findViewById(R.id.barber_recycler);


        barber_recycler.setLayoutManager(new LinearLayoutManager(this));

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf1 = new SimpleDateFormat("EEEE MMMM dd, yyyy");
        datedata = sdf.format(cal.getTime());


        Date date = new Date();
        currentDate = sdf.format(date);
        getDate.setText(sdf1.format(date));
        day = getDate.getText().toString();
        weekday = day.split(" ");

    }
}
