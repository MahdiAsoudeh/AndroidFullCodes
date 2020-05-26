package com.mahdi20.fullcodes.eventBusExample;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class EventBusActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        textView = findViewById(R.id.textView);


        // this is send msg to bus
        findViewById(R.id.btn).setOnClickListener(v -> {

//            EventBus.getDefault().post(new EventModel("hiiiii from event bus"));

            Intent serviceIntent = new Intent(EventBusActivity.this, MyService.class);
            startService(serviceIntent);



        });


    }

    // this is receive msg from bus
//    @Subscribe
//    @Subscribe(threadMode = ThreadMode.POSTING)
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    @Subscribe(priority = 1)
//    public void getMessage(EventModel eventModel) {
//        textView.setText("" + eventModel.getMessage());
//        Toast.makeText(this, "str: " + eventModel.getMessage(), Toast.LENGTH_SHORT).show();

//        EventBus.getDefault().cancelEventDelivery(event);

//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventFromService(EventModel event) {
        textView.setText(event.getMessage());
    }


    @Override
    protected void onStart() {
        super.onStart();
        // this is register on bus
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // this is unregister from bus
        EventBus.getDefault().unregister(this);
    }


}