package com.example.intentrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private Runnable task_wainting_ = new Runnable() {
        @Override
        public void run() {
            while (true) {
                IsWaintingIntent();
            }
        }
    };
    private Runnable task_sending_ = new Runnable() {
        @Override
        public void run() {
            while (true) {
                SendIntent();
            }
        }
    };
    protected void SendIntent(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "PLEASE_I_NEED_TITLE");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
    protected boolean IsWaintingIntent(){
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {

                String Title = intent.getStringExtra(Intent.EXTRA_TEXT);
                if(Title!=null) {
                    setTitle(Title);
                    return true;
                }
            }
        }
        setTitle("WAIT_REQUEST");
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(task_sending_).start();

        new Thread(task_wainting_).start();

    }
}