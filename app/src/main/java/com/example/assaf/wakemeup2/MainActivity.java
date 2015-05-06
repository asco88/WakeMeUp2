package com.example.assaf.wakemeup2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    NumberPicker hours, minutes;
    Button startBtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        init(this);
    }

    public void init(Context context) {
        hours = (NumberPicker) findViewById(R.id.numberPickerHours);
        minutes = (NumberPicker) findViewById(R.id.numberPickerMinutes);
        startBtn = (Button) findViewById(R.id.startBtn);

        hours.setMinValue(0);
        hours.setMaxValue(12);

        minutes.setMinValue(5);
        minutes.setMaxValue(55);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initClock();
            }
        });
    }

    public void initClock() {
        AlarmManager alarmManager;
        PendingIntent alarmIntent;

        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set;

        Calendar calNow = Calendar.getInstance();
        Calendar calSet = (Calendar)calNow.clone();

        calSet.set(Calendar.HOUR_OF_DAY, 12);
        calSet.set(Calendar.MINUTE, 45);
        calSet.set(Calendar.SECOND, 0);


        Intent myIntent = new Intent(AndroidAlarmService.this, MyAlarmService.class);
        pendingIntent = PendingIntent.getService(AndroidAlarmService.this, 0, myIntent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(AndroidAlarmService.this, "Start Alarm", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
