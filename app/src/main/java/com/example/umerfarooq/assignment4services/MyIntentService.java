package com.example.umerfarooq.assignment4services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Umer Farooq on 12/27/2017.
 */

public class MyIntentService extends IntentService {
    public static volatile boolean shouldContinue = true;


    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.salman.uolfall17serviceassignment.action.FOO";
    private static final String ACTION_BAZ = "com.example.salman.uolfall17serviceassignment.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.salman.uolfall17serviceassignment.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.salman.uolfall17serviceassignment.extra.PARAM2";
    private static final String TAG = "MTAG";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int Limit = intent.getIntExtra("Limit", 0);

        for (int i = 0; i < Limit; i++) {

            stopService();
            try {
                Thread.sleep(1000);
                int percentage = (i * 100) / Limit;
                CustomMessageEvent customMessageEvent = new CustomMessageEvent();
                customMessageEvent.setLimit(percentage);
                EventBus.getDefault().post(customMessageEvent);


                Log.d(TAG, "onHandleIntent:service started " + i);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: Service Stopped");

    }

    private void stopService() {

        if (shouldContinue == false) {
            stopSelf();
            return;
        }
    }
}
