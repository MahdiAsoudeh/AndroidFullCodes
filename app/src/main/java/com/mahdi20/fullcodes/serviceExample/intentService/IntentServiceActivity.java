package com.mahdi20.fullcodes.serviceExample.intentService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mahdi20.fullcodes.R;

public class IntentServiceActivity extends Activity {

    private TextView textView;
    private Button button1;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

//                String string = bundle.getString(DownloadService.FILEPATH);
                int resultCode = bundle.getInt(DownloadService.RESULT);

                if (resultCode == RESULT_OK) {

//                    Toast.makeText(IntentServiceExampleActivity.this,
//                            "Download complete. Download URI: " + string,
//                            Toast.LENGTH_LONG).show();

                    textView.setText("Download done");

                } else {
//                    Toast.makeText(IntentServiceExampleActivity.this, "Download failed",
//                            Toast.LENGTH_LONG).show();
                    textView.setText("Download failed");
                }
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_example);

        textView = findViewById(R.id.status);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(v -> {


            startService();

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(
                DownloadService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void startService() {

        Intent intent = new Intent(this, DownloadService.class);
        // add infos for the service which file to download and where to store
//        intent.putExtra(DownloadService.FILENAME, "index.html");
//        intent.putExtra(DownloadService.URL, "http://www.vogella.com/index.html");

        startService(intent);

        textView.setText("Service started");

    }
}