package com.example.umerfarooq.assignment4services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    Button btnStartService;
    Button btnStopService;
    TextView servicePercentage;
    EditText serviceLimit;
    TextView symbol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        servicePercentage = findViewById(R.id.servicePercentage);
        serviceLimit = findViewById(R.id.serviceLimit);
        symbol = findViewById(R.id.percentageSymbol);

        EventBus.getDefault().register(this);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MyIntentService.class);


                int finalValue = Integer.parseInt(serviceLimit.getText().toString());
                intent.putExtra("Limit", finalValue);
                startService(intent);

            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyIntentService.shouldContinue = false;


            }
        });


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CustomMessageEvent event) {
        Integer i = event.getLimit();
        servicePercentage.setText(i.toString());


    }
}
