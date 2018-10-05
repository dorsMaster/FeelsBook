package com.example.dors.feelsbook;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class Stats extends AppCompatActivity {
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;
    int angry, fear, surprised, love, joy, sad = 0;

    /**
     * gets data from shared pref, and maps the value of the emotion, and counts them
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            switch (entry.getValue().toString().substring(0,1)){
                case "1":
                    sad ++;
                    break;
                case "2":
                    angry++;
                    break;
                case "3":
                    joy++;
                    break;
                case "4":
                    surprised++;
                    break;
                case "5":
                    love++;
                    break;
                case "6":
                    fear++;
                    break;
                default:
                    break;

            }
        }
        ((TextView)findViewById(R.id.sadStats)).setText(String.valueOf(sad));
        ((TextView)findViewById(R.id.angryStats)).setText(String.valueOf(angry));
        ((TextView)findViewById(R.id.fearStats)).setText(String.valueOf(fear));
        ((TextView)findViewById(R.id.surprisedStats)).setText(String.valueOf(surprised));
        ((TextView)findViewById(R.id.loveStats)).setText(String.valueOf(love));
        ((TextView)findViewById(R.id.happyStats)).setText(String.valueOf(joy));
    }


}