package com.hacktiv8.sesi10;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class BackgroudService extends IntentService {

    public BackgroudService() {
        super("My-Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int sleep = intent.getIntExtra("sleep", 1);

        int counter = 0;
        while (counter < sleep){
            Log.i("Sleep Thread:", Thread.currentThread().getName() );
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;
        }

    }
}
