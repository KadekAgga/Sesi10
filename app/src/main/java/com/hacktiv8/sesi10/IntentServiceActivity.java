package com.hacktiv8.sesi10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
    }


    public void startService(View view) {
        Intent intentService = new Intent(IntentServiceActivity.this, BackgroudService.class);
        intentService.putExtra("sleep", 100);
        startService(intentService);
    }
}