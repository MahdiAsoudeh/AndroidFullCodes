package com.mahdi20.fullcodes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.asyncTaskExample.AsyncTaskExample;
import com.mahdi20.fullcodes.recyclerviewExample.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.rcyBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.asyncBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AsyncTaskExample.class);
            startActivity(intent);
        });


    }
}
