package com.hacktiv8.sesi10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.status_text);
    }

    public void hitMe(View view) {
        statusText.setText("Start...");

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                Log.i("TEST_THREAD", "START");

                synchronized (this) {

                    try{
                        wait(5000);
                        //TODO
                        //HIT API
                        //BACA DB
                        //Proses di Background

                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Log.i("TEST_THREAD", "SELESAI");
                        statusText.setText("Selesai...");

                        //START INTENT
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);

                    }
                });

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}