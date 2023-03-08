package com.example.intentrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private String Title = null;
    public void SendIntent(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction("ru.alexanderklimov.action.REQUEST");
        sendIntent.putExtra("TITLE_PLEASE", "PLEASE_I_NEED_TITLE");
        sendIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(sendIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}