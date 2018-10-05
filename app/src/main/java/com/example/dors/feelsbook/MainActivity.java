/*
Student Picker: Randomly pick students to answer questionsdorsa@ualberta.caabram.hindle@softwareprocess.ca
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/


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
