package com.hacktiv8.sesi10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    private ProgressBar progressBarDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        progressBarDownload = findViewById(R.id.progress_download);
    }

    public void download(View view) {
        AsyncTaskDownload asyncTaskDownload = new AsyncTaskDownload();
        asyncTaskDownload.execute(10);
    }

    private class AsyncTaskDownload extends AsyncTask<Integer, Integer, String>{

        public AsyncTaskDownload(){
        }

        @Override
        protected void onPreExecute(){

            progressBarDownload.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for(int i=0; i<integers[0]; i++){

                publishProgress((i*100) / integers[0]);

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Download Selesai";
        }

        @Override
        protected void onProgressUpdate(Integer... integers){
            super.onProgressUpdate(integers);
            progressBarDownload.setProgress(integers[0]);
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            Toast.makeText(AsyncTaskActivity.this, s, Toast.LENGTH_LONG).show();
            progressBarDownload.setProgress(0);
            progressBarDownload.setVisibility(View.GONE);


        }





    }
}