package com.sander.rogue_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private Intent screenSaverSIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sd_configView();

    }


    private void sd_configView()
    {
        Log.d("sander","test log d");

        screenSaverSIntent = new Intent(MainActivity.this,ScreenSaverS.class);


        startService(screenSaverSIntent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("sander","destroy");
    }
}
