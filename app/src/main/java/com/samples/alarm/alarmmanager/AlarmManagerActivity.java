package com.samples.alarm.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class AlarmManagerActivity extends Activity
        implements View.OnClickListener{

    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        intent = new Intent(AlarmManagerActivity.this, AlarmService.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bStart:
                pendingIntent = PendingIntent.getService(getApplicationContext(), 0, intent, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(calendar.SECOND, 5);
                alarmManager.setRepeating(
                        AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        5000,
                        pendingIntent);
                break;
            case R.id.bCancel:
                alarmManager.cancel(pendingIntent);
                break;
            case R.id.bStop:
                this.stopService(intent);
                break;
        }
    }
}
