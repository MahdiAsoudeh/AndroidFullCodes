package com.mahdi20.fullcodes.recyclerviewExample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdi20.fullcodes.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {


    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            animalNames.add("Horse " + i);
        }

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this, animalNames);
        recyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + recyclerViewAdapter.getItem(position) +
                " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}
