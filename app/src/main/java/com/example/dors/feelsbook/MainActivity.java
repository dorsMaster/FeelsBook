package com.example.dors.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToTodayActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, Today.class)});

    }


    //    public void changeToHistoryActivity(View view) {
//        startActivities(new Intent[]{new Intent(MainActivity.this, Calendar.class)});
//    }
    public void changeToStatsActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, Stats.class)});
    }
    public void changeToHistoryActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, History.class)});
    }


}
