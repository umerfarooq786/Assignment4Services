package com.example.umerfarooq.assignment4services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Umer Farooq on 12/27/2017.
 */

public class MyService extends Service{
    private static final String TAG = "MTAG";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // return super.onStartCommand(intent, flags, startId);

        Log.d(TAG, "onStartCommand: Service Started");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "onStartCommand: Service Started" + i);
            } catch (InterruptedException e) {

            }
        }
        return START_NOT_STICKY;
    }

}
