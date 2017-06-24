package com.samples.alarm.alarmmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by use on 24.06.17.
 */
public class AlarmService extends Service {

    private int count;

    @Override
    public void onCreate() {
        count = 0;
        Toast.makeText(this, "Create service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Bind service", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        count++;
        Toast.makeText(this, "Notify from alarm service #" + count, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Unbind service", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
