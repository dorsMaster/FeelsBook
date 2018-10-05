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
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Today extends AppCompatActivity {
    EditText txt;
    int emotion;
    //    Button saveButton;
    Context context;
    private final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private final String MESSAGE_DATE = "com.example.myfirstapp.DATE";
    private boolean hasDate;
    private String intentDate;
    private ImageButton angry, joy, surprised, sad, love, fear;
    private EditText yEdit,mEdit,dEdit,hEdit,minEdit,secEdit;


    /**
     * To set up the date format and the text boxes
     * @param savedInstanceState
     */
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
        hasDate = false;
        txt= findViewById(R.id.plain_text_input);
        Bundle extras = getIntent().getExtras();
        DateFormat ydateFormat = new SimpleDateFormat("yyyy", Locale.CANADA);
        DateFormat mdateFormat = new SimpleDateFormat("MM", Locale.CANADA);
        DateFormat ddateFormat = new SimpleDateFormat("dd", Locale.CANADA);

        DateFormat hdateFormat = new SimpleDateFormat("HH", Locale.CANADA);
        DateFormat mindateFormat = new SimpleDateFormat("mm", Locale.CANADA);
        DateFormat sdateFormat = new SimpleDateFormat("ss", Locale.CANADA);


        Date date = Calendar.getInstance().getTime();
        String myYear = ydateFormat.format(date);
        String myMonth = mdateFormat.format(date);
        String myDay = ddateFormat.format(date);

        String myHour = hdateFormat.format(date);
        String myMin = mindateFormat.format(date);
        String mySec = sdateFormat.format(date);

        yEdit = (EditText)findViewById(R.id.yEdit);
        mEdit = (EditText)findViewById(R.id.mEdit);
        dEdit = (EditText)findViewById(R.id.dEdit);
        hEdit = (EditText)findViewById(R.id.hourEdit);
        minEdit = (EditText)findViewById(R.id.minEdit);
        secEdit = (EditText)findViewById(R.id.secEdit);



        yEdit.setText(myYear);
        mEdit.setText(myMonth);
        dEdit.setText(myDay);

        hEdit.setText(myHour);
        minEdit.setText(myMin);
        secEdit.setText(mySec);


        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        String todayText = readData(myYear+myMonth+myDay+myHour+myMin+mySec);
        Log.d("TODAYIS",todayText);
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
//            ((TextView)(findViewById(R.id.dateOfToday))).setText(intentDate);
            intentDate = intentDate.replace("/","");
            intentDate = intentDate.replace(":","");
            intentDate = intentDate.replace(" ","");

            yEdit.setText(intentDate.substring(0,4));
            mEdit.setText(intentDate.substring(4,6));
            dEdit.setText(intentDate.substring(6,8));

            hEdit.setText(intentDate.substring(8,10));
            minEdit.setText(intentDate.substring(10,12));
            secEdit.setText(intentDate.substring(12,14));


            txt.setText(message);
            SetEmojiButton(emojiVal);

            hasDate = true;
            yEdit.setEnabled(true);
            mEdit.setEnabled(true);
            dEdit.setEnabled(true);
            hEdit.setEnabled(true);
            minEdit.setEnabled(true);
        }

    }

    /**
     * claes the emoji
     * @param emojiVal
     */
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

    /**
     * to read data from the shared preferences
     * @param date
     * @return
     */
    public String readData(String date) {
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String value = sharedPref.getString(date," ");
        return value;
    }

    /**
     * saves the new set of data
     */
    public void saveData (){
        int emotion = this.emotion;
        String input =  String.valueOf(emotion)+ txt.getText().toString();
        String key = yEdit.getText().toString() + mEdit.getText().toString()+dEdit.getText().toString()+hEdit.getText().toString()+minEdit.getText().toString()+secEdit.getText().toString();
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.d("THIS_YEAR", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        if((Integer.valueOf(mEdit.getText().toString()) > 0) && (Integer.valueOf(mEdit.getText().toString()) < 13)
                && (Integer.valueOf(dEdit.getText().toString()) > 0) && (Integer.valueOf(dEdit.getText().toString()) <= 31)
                && (Integer.valueOf(hEdit.getText().toString()) < 24) && (Integer.valueOf(hEdit.getText().toString()) >= 0)
                && (Integer.valueOf(yEdit.getText().toString()) <= (Calendar.getInstance().get(Calendar.YEAR))) && (Integer.valueOf(yEdit.getText().toString()) >= 0)
                && (Integer.valueOf(minEdit.getText().toString()) >= 0) && (Integer.valueOf(minEdit.getText().toString()) < 60)) {
            if (hasDate) {
                editor.remove(intentDate);
            }
            editor.putString(key, input);
            editor.apply();
            Log.d("SAVEACTIONKEY", key);
            goToNextActivity(com.example.dors.feelsbook.MainActivity.class);
            finish();
        }else{
            Toast.makeText(this, "Date or Time is not correct!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setSurprised(View view) {
        emotion = 4;
        saveData();
        surprised.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


    }

    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setAngry(View view) {
        emotion = 2;
        saveData();
        angry.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setFear(View view) {
        emotion = 6;
        saveData();
        fear.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setLove(View view) {
        emotion = 5;
        saveData();
        love.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setSad(View view) {
        emotion = 1;
        saveData();
        sad.setScaleType(ImageView.ScaleType.FIT_CENTER);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        joy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

    }
    /**
     * makes the motion chosen bigger and creates some animation
     * @param view
     */
    public void setJoy(View view) {
        emotion = 3;
        saveData();
        joy.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sad.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        surprised.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        love.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        angry.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fear.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    /**
     * goes to the next acitivity after clicking
     * @param nextActivity
     */
    public void goToNextActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

}








