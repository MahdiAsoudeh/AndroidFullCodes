package com.mahdi20.fullcodes.asyncTaskExample;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.R;

public class AsyncTaskExample extends AppCompatActivity {
    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        time = findViewById(R.id.in_time);
        button = findViewById(R.id.btn_run);
        finalResult = findViewById(R.id.tv_result);
        button.setOnClickListener(v -> {
            AsyncTaskRunner runner = new AsyncTaskRunner();
            String sleepTime = time.getText().toString();
            runner.execute(sleepTime);
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            finalResult.setText(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(AsyncTaskExample.this,
                    "ProgressDialog",
                    "Wait for " + time.getText().toString() + " seconds");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);

        }
    }
}
