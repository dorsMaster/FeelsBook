package com.example.dors.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     * makes the activity to be defaulted as activity_main
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * once clicked it changes the activity
     * @param view
     */
    public void changeToTodayActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, Today.class)});
    }

    /**
     * once clicked it changes the activity
     * @param view
     */
    public void changeToStatsActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, Stats.class)});
    }

    /**
     * once clicked it changes the activity
     * @param view
     */
    public void changeToHistoryActivity(View view) {
        startActivities(new Intent[]{new Intent(MainActivity.this, History.class)});
    }


}
