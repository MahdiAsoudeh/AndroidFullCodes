package com.mahdi20.fullcodes.retrofitExample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdi20.fullcodes.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity implements PersonAdapter.OnItemClickListener {

    private ApiRepository apiRepository;
    private Button addButton;
    private RecyclerView recyclerView;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        // init
        apiRepository = RetrofitInstance.getApiService();
        addButton = findViewById(R.id.addButton);
        recyclerView = findViewById(R.id.recyclerView);
        count = findViewById(R.id.count);


        callgetAllPerson();


        addButton.setOnClickListener(v -> {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    setCount(i);
                    callInsertPerson(new Person("mehdi", "asoodeh", "0936ATA7111"));
                }
            });
            thread.start();
        });


    }

    private void callInsertPerson(Person person) {

        Call<Void> call = apiRepository.insert(person);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {

//                if (response.isSuccessful()) {
//                    Toast.makeText(RetrofitActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                    callgetAllPerson();
//                }

                Log.i("######", "" + response.isSuccessful());

            }

            @Override
            public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                Toast.makeText(RetrofitActivity.this, "error", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }


    private void callgetAllPerson() {

        Call<List<Person>> call = apiRepository.getAll();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(@NotNull Call<List<Person>> call, @NotNull Response<List<Person>> response) {
//                Toast.makeText(RetrofitActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    fillRecy(response.body());
                }

            }

            @Override
            public void onFailure(@NotNull Call<List<Person>> call, @NotNull Throwable t) {
//                Toast.makeText(RetrofitActivity.this, "error", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    private void fillRecy(List<Person> personList) {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PersonAdapter adapter = new PersonAdapter(personList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(View view, Person item, int position) {
        Toast.makeText(RetrofitActivity.this, "" + position, Toast.LENGTH_SHORT).show();
    }

    private void setCount(int a) {
        runOnUiThread(() -> {
            count.setText("count: " + a);
        });
    }


}
