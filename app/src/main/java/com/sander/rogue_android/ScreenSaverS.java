package com.sander.rogue_android;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.sander.rogue_libs.PowerManagerWakeLock;

import static android.content.Intent.getIntent;

public class ScreenSaverS extends Service {


    private class start_class;
    public ScreenSaverS() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();




        String start_class_string = Intent

        Log.d("sander","service on create");
        KeyguardManager manager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock lock = manager
                .newKeyguardLock("KeyguardLock");
        lock.disableKeyguard();

        // 注册一个监听屏幕开启和关闭的广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenReceiver, filter);
    }

    BroadcastReceiver screenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_SCREEN_ON)) {
                Log.d("sander","ACTION_SCREEN_ON");
            } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {//如果接受到关闭屏幕的广播
                Log.d("sander","ACTION_SCREEN_OFF");
                PowerManagerWakeLock.acquire(ScreenSaverS.this);

                PowerManagerWakeLock.acquire(ScreenSaverS.this);
                Intent intent2 = new Intent(ScreenSaverS.this,
                        MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                PowerManagerWakeLock.release();
            }
        }
    };
}
