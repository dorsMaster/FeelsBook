package com.example.dors.feelsbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Today extends AppCompatActivity {
    EditText txt;
    int emotion;
    Button saveButton;
    Context context;
    private final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private final String MESSAGE_DATE = "com.example.myfirstapp.DATE";
    private boolean hasDate = false;
    private String intentDate;
    private ImageButton angry, joy, surprised, sad, love, fear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        angry = findViewById(R.id.angry);
        joy = findViewById(R.id.joy);
        surprised = findViewById(R.id.surprised);
        fear = findViewById(R.id.fear);
        love = findViewById(R.id.love);
        sad = findViewById(R.id.sad);
        context = this;
        txt= findViewById(R.id.plain_text_input);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setClickable(false);
        Bundle extras = getIntent().getExtras();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CANADA);
        Date date = Calendar.getInstance().getTime();
        String myDate = dateFormat.format(date);
        Log.d("NEWDATE", myDate);
        ((TextView)(findViewById(R.id.dateOfToday))).setText(myDate);


        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        String todayText = readData(myDate.replace("/",""));
        if (!todayText.equalsIgnoreCase(" ")){
            txt.setText(todayText.substring(1,todayText.length()));
            String emojiVal = todayText.substring(0,1);
            SetEmojiButton(emojiVal);
        }


        if (extras != null){
            String message = extras.getString(EXTRA_MESSAGE);
            String emojiVal = message.substring(0,1);
            message = message.substring(1,message.length());
            intentDate = extras.getString(MESSAGE_DATE);
            ((TextView)(findViewById(R.id.dateOfToday))).setText(intentDate);
            intentDate = intentDate.replace("/","");
            txt.setText(message);
            SetEmojiButton(emojiVal);

            hasDate = true;
        }

    }


    public void SetEmojiButton(String emojiVal){
        switch (emojiVal){
            case "1":
                sad.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "2":
                angry.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "3":
                joy.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "4":
                surprised.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "5":
                love.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "6":
                fear.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            default:
                break;
        }
    }


    public String readData(String date) {
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String value = sharedPref.getString(date," ");
        return value;
    }


    public void saveData (View v){

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CANADA);
        Date date = Calendar.getInstance().getTime();
        Log.d("MYTEST",dateFormat.format(date));
        int emotion = this.emotion;
        String input =  String.valueOf(emotion)+ txt.getText().toString();
        String key = dateFormat.format(date);
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(hasDate){
            editor.putString(intentDate,input);

        }else {
            editor.putString(key, input);


        }
        editor.apply();
        Log.d("SAVEACTIONKEY",key);
        goToNextActivity(com.example.dors.feelsbook.MainActivity.class);
        finish();
        }

    public void setSurprised(View view) {
        emotion = 4;
        saveButton.setClickable(true);
        surprised.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


    }

    public void setAngry(View view) {
        emotion = 2;
        saveButton.setClickable(true);
        angry.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setFear(View view) {
        emotion = 6;
        saveButton.setClickable(true);
        fear.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setLove(View view) {
        emotion = 5;
        saveButton.setClickable(true);
        love.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setSad(View view) {
        emotion = 1;
        saveButton.setClickable(true);
        sad.setScaleType(ImageView.ScaleType.FIT_CENTER);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

    }

    public void setJoy(View view) {
        emotion = 3;
        saveButton.setClickable(true);
        joy.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void goToNextActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

}








